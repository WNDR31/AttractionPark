package com.example.demo.controllers;

import com.example.demo.entity.Attraction;
import com.example.demo.repository.AttractionRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.repository.ThrillRepository;
import com.example.demo.repository.TypeRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class AttractionsController {
    
    private final AttractionRepository attractionRepository;
    private final ZoneRepository zoneRepository;
    private final ThrillRepository thrillRepository;
    private final TypeRepository typeRepository;

    public AttractionsController(AttractionRepository attractionRepository,
                               ZoneRepository zoneRepository,
                               ThrillRepository thrillRepository,
                               TypeRepository typeRepository) {
        this.attractionRepository = attractionRepository;
        this.zoneRepository = zoneRepository;
        this.thrillRepository = thrillRepository;
        this.typeRepository = typeRepository;
    }

    // Lista todas las atracciones con datos para los filtros
    @GetMapping("/attractionsgalery")
    public String getAttractions(Model model) {
        model.addAttribute("attractions", attractionRepository.findAll());
        loadFilterData(model);
        return "attractionsgalery";
    }

    // Muestra una atracción específica
    @GetMapping("/attractions/{id}")
    public String getAttractionDetails(@PathVariable Long id, Model model) {
        Attraction attraction = attractionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Atracción no encontrada con id: " + id));
        model.addAttribute("attraction", attraction);
        return "attractions";
    }

    // Atracciones por zona (ID)
    @GetMapping("/attractions/zone/{zoneId}")
    public String getAttractionsByZone(@PathVariable Long zoneId, Model model) {
        model.addAttribute("attractions", attractionRepository.findByZoneId(zoneId));
        loadFilterData(model);
        return "attractionsgalery";
    }

    // Atracciones por nombre de zona
    @GetMapping("/attractions/zone")
    public String getAttractionsByZoneName(@RequestParam String name, Model model) {
        model.addAttribute("attractions", attractionRepository.findByZoneName(name));
        loadFilterData(model);
        return "attractionsgalery";
    }

    // Atracciones por tipo (ID)
    @GetMapping("/attractions/type/{typeId}")
    public String getAttractionsByType(@PathVariable Long typeId, Model model) {
        model.addAttribute("attractions", attractionRepository.findByTypeId(typeId));
        loadFilterData(model);
        return "attractionsgalery";
    }

    // Atracciones por nombre de tipo
    @GetMapping("/attractions/type")
    public String getAttractionsByTypeName(@RequestParam String name, Model model) {
        model.addAttribute("attractions", attractionRepository.findByTypeName(name));
        loadFilterData(model);
        return "attractionsgalery";
    }

    // Atracciones por intensidad (ID)
    @GetMapping("/attractions/intensity/{intensityId}")
    public String getAttractionsByIntensity(@PathVariable Long intensityId, Model model) {
        model.addAttribute("attractions", attractionRepository.findByIntensityId(intensityId));
        loadFilterData(model);
        return "attractionsgalery";
    }

    // Atracciones por nombre de intensidad
    @GetMapping("/attractions/intensity")
    public String getAttractionsByIntensityName(@RequestParam String name, Model model) {
        model.addAttribute("attractions", attractionRepository.findByIntensityName(name));
        loadFilterData(model);
        return "attractionsgalery";
    }
        
    @GetMapping("/map")
    public String showParkMap(Model model) {
        return "map"; // Renderiza el mapa completo
    }

    @GetMapping("/attractions/filter")
public String filterAttractions(
        @RequestParam(required = false) String zone,
        @RequestParam(required = false) String intensity,
        @RequestParam(required = false) String type,
        Model model) {
    
    // Añade estos atributos para mantener los filtros seleccionados
    model.addAttribute("selectedZone", zone);
    model.addAttribute("selectedIntensity", intensity);
    model.addAttribute("selectedType", type);
    
    List<Attraction> filteredAttractions;
    
    if ((zone == null || zone.isEmpty()) && 
        (intensity == null || intensity.isEmpty()) && 
        (type == null || type.isEmpty())) {
        filteredAttractions = attractionRepository.findAll();
    } else {
        filteredAttractions = attractionRepository.findByCombinedFilters(
            zone != null && !zone.isEmpty() ? zone : null,
            intensity != null && !intensity.isEmpty() ? intensity : null,
            type != null && !type.isEmpty() ? type : null
        );
    }
    
    model.addAttribute("attractions", filteredAttractions);
    loadFilterData(model);
    return "attractionsgalery";
}

    // Método para cargar datos de filtros
    private void loadFilterData(Model model) {
        model.addAttribute("zones", zoneRepository.findAllByOrderByNameAsc());
        model.addAttribute("intensities", thrillRepository.findAllByOrderByNameAsc());
        model.addAttribute("types", typeRepository.findAllByOrderByNameAsc());
    }
}