package com.example.demo.controllers; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping; 
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.StoreRepository;

import org.springframework.ui.Model;
import java.util.List;
import com.example.demo.entity.Hotel;
import com.example.demo.entity.Restaurant;
import com.example.demo.entity.Store;

@Controller 
public class VisitPlanController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/planifica-tu-visita") 
    public String mostrarHoteles(Model model) {
        List<Hotel> hoteles = hotelRepository.findAll();
        List<Restaurant> restaurantes = restaurantRepository.findAll();
        List<Store> tiendas = storeRepository.findAll();

        model.addAttribute("hoteles", hoteles);
        model.addAttribute("restaurantes", restaurantes);
        model.addAttribute("tiendas", tiendas);
        return "PlanificaTuVisita";  // html estatico
    }
}