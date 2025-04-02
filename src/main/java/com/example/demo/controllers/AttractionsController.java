package com.example.demo.controllers;

import com.example.demo.entity.Attraction;
import com.example.demo.repository.AttractionRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AttractionsController {
    
    private final AttractionRepository attractionRepository;

    public AttractionsController(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    // Lista todas las atracciones
    @GetMapping("/attractionsgalery")
    public String getAttractions(Model model) {
        List<Attraction> attractions = attractionRepository.findAll();
        model.addAttribute("attractions", attractions);
        return "attractionsgalery";
    }

    // Muestra una atracción específica
    @GetMapping("/attractions/{id}")
    public String getAttractionDetails(@PathVariable Long id, Model model) {
        Attraction attraction = attractionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Atracción no encontrada con id: " + id));
        model.addAttribute("attraction", attraction);
        return "attraction-details";
    }

    // Atracciones por zona (ID)
    @GetMapping("/attractions/zone/{zoneId}")
    public String getAttractionsByZone(@PathVariable Long zoneId, Model model) {
        model.addAttribute("attractions", attractionRepository.findByZoneId(zoneId));
        return "attractionsgalery";
    }

    // Atracciones por nombre de zona
    @GetMapping("/attractions/zone")
    public String getAttractionsByZoneName(@RequestParam String name, Model model) {
        model.addAttribute("attractions", attractionRepository.findByZoneName(name));
        return "attractionsgalery";
    }

    // Atracciones por tipo (ID)
    @GetMapping("/attractions/type/{typeId}")
    public String getAttractionsByType(@PathVariable Long typeId, Model model) {
        model.addAttribute("attractions", attractionRepository.findByTypeId(typeId));
        return "attractionsgalery";
    }

    // Atracciones por nombre de tipo
    @GetMapping("/attractions/type")
    public String getAttractionsByTypeName(@RequestParam String name, Model model) {
        model.addAttribute("attractions", attractionRepository.findByTypeName(name));
        return "attractionsgalery";
    }

    // Atracciones por intensidad (ID)
    @GetMapping("/attractions/intensity/{intensityId}")
    public String getAttractionsByIntensity(@PathVariable Long intensityId, Model model) {
        model.addAttribute("attractions", attractionRepository.findByIntensityId(intensityId));
        return "attractionsgalery";
    }

    // Atracciones por nombre de intensidad
    @GetMapping("/attractions/intensity")
    public String getAttractionsByIntensityName(@RequestParam String name, Model model) {
        model.addAttribute("attractions", attractionRepository.findByIntensityName(name));
        return "attractionsgalery";
    }

    // Filtro combinado (para el formulario de tu HTML)
    @GetMapping("/attractions/filter")
    public String filterAttractions(
            @RequestParam(required = false) String zone,
            @RequestParam(required = false) String intensity,
            @RequestParam(required = false) String type,
            Model model) {
        
        List<Attraction> filteredAttractions = attractionRepository.findAll();
        
        if (zone != null && !zone.isEmpty()) {
            filteredAttractions = filteredAttractions.stream()
                .filter(a -> a.getZone() != null && a.getZone().getName().equals(zone))
                .toList();
        }
        
        if (intensity != null && !intensity.isEmpty()) {
            filteredAttractions = filteredAttractions.stream()
                .filter(a -> a.getIntensity() != null && a.getIntensity().getName().equals(intensity))
                .toList();
        }
        
        if (type != null && !type.isEmpty()) {
            filteredAttractions = filteredAttractions.stream()
                .filter(a -> a.getType() != null && a.getType().getName().equals(type))
                .toList();
        }
        
        model.addAttribute("attractions", filteredAttractions);
        return "attractionsgalery";
    }
}