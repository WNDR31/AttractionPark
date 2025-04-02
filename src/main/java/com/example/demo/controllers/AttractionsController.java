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

    // O por nombre de zona:
    @GetMapping("/attractions/zone")
    public String getAttractionsByZoneName(@RequestParam String name, Model model) {
        model.addAttribute("attractions", attractionRepository.findByZoneName(name));
        return "attractionsgalery";
    }
    
    
}