package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepository;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class VisitPlanController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("Hoteles")
    public String mostrarHoteles(Model model) {
        List<Hotel> hoteles = hotelRepository.findAll();
        model.addAttribute("hoteles", hoteles);
        return "PlanificaTuVisita";  // Nombre de la vista HTML
    }
}

