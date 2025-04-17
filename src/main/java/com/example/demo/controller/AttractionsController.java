package com.example.demo.controller;

import com.example.demo.entity.Attraction;
import com.example.demo.repository.AttractionRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.repository.ThrillRepository;
import com.example.demo.repository.TypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // ----- CRUD para Thymeleaf (list.html y form.html) -----

     // Listar todas las atracciones (list.html)
     @GetMapping("/attractions")
     public String showAttractionList(Model model) {
         model.addAttribute("attractions", attractionRepository.findAll());
         return "list";
     }
 
     // Mostrar formulario para crear nueva atracción (form.html)
     @GetMapping("/attractions/new")
     public String showCreateForm(Model model) {
         model.addAttribute("attraction", new Attraction());
         model.addAttribute("zones", zoneRepository.findAllByOrderByNameAsc());
         model.addAttribute("intensities", thrillRepository.findAllByOrderByNameAsc());
         model.addAttribute("types", typeRepository.findAllByOrderByNameAsc());
         return "form";
     }
 
     // Mostrar formulario para editar una atracción existente (form.html)
     @GetMapping("/attractions/{id}/edit")
     public String showEditForm(@PathVariable Long id, Model model) {
         Attraction attraction = attractionRepository.findById(id)
                 .orElseThrow(() -> new IllegalArgumentException("Atracción no encontrada con id: " + id));
         model.addAttribute("attraction", attraction);
         model.addAttribute("zones", zoneRepository.findAllByOrderByNameAsc());
         model.addAttribute("intensities", thrillRepository.findAllByOrderByNameAsc());
         model.addAttribute("types", typeRepository.findAllByOrderByNameAsc());
         return "form";
     }
 
     // Guardar una atracción (crear o editar)
     @PostMapping("/attractions")
     public String saveAttraction(@ModelAttribute Attraction attraction) {
         attractionRepository.save(attraction);
         return "redirect:/attractions";
     }
 
     // Eliminar una atracción
     @GetMapping("/attractions/{id}/delete")
     public String deleteAttraction(@PathVariable Long id) {
         attractionRepository.deleteById(id);
         return "redirect:/attractions";
     }
    // ----- Métodos de galería y filtros avanzados -----

    // Lista todas las atracciones con datos para filtros (galería)
    @GetMapping("/attractionsgalery")
    public String getAttractions(Model model) {
        model.addAttribute("attractions", attractionRepository.findAll());
        loadFilterData(model);
        return "attractionsgalery";
    }

    // Muestra detalles de una atracción específica
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

    // Filtro combinado de atracciones
    @GetMapping("/attractions/filter")
    public String filterAttractions(
            @RequestParam(required = false) String zone,
            @RequestParam(required = false) String intensity,
            @RequestParam(required = false) String type,
            Model model) {

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
                    (zone != null && !zone.isEmpty()) ? zone : null,
                    (intensity != null && !intensity.isEmpty()) ? intensity : null,
                    (type != null && !type.isEmpty()) ? type : null
            );
        }

        model.addAttribute("attractions", filteredAttractions);
        loadFilterData(model);
        return "attractionsgalery";
    }

    // Mapa del parque
    @GetMapping("/map")
    public String showParkMap(Model model) {
        return "map";
    }

    // Método auxiliar para cargar datos de los filtros
    private void loadFilterData(Model model) {
        model.addAttribute("zones", zoneRepository.findAllByOrderByNameAsc());
        model.addAttribute("intensities", thrillRepository.findAllByOrderByNameAsc());
        model.addAttribute("types", typeRepository.findAllByOrderByNameAsc());
    }
}
