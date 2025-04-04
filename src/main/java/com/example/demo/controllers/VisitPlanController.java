package com.example.demo.controllers; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping; 
import com.example.demo.repository.HotelRepository;
import org.springframework.ui.Model;
import java.util.List;
import com.example.demo.entity.Hotel;

@Controller 
public class VisitPlanController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/planifica-tu-visita") 
    public String mostrarHoteles(Model model) {
        List<Hotel> hoteles = hotelRepository.findAll();
        System.out.println("Número de hoteles encontrados:" + hoteles.size());
        model.addAttribute("hoteles", hoteles);
        return "PlanificaTuVisita.html";  // html estatico
    }
}