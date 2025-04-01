package com.example.demo.controllers;

import com.example.demo.entity.Attraction;
import com.example.demo.repository.AttractionRepository;

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

    @GetMapping("/attractions")
    public String getAttractions(Model model) {
        List<Attraction> attractions = attractionRepository.findAll();
        model.addAttribute("attractions", attractions);
        return "attractions";
    }
}
