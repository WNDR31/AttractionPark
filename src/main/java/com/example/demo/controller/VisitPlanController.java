package com.example.demo.controller;

import com.example.demo.services.HotelService;
import com.example.demo.services.RestaurantService;
import com.example.demo.services.StoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import java.util.List;
import com.example.demo.entity.Hotel;
import com.example.demo.entity.Restaurant;
import com.example.demo.entity.Store;

@Controller
public class VisitPlanController {

    private final HotelService hotelService;
    private final RestaurantService restaurantService;
    private final StoreService storeService;

    @Autowired
    public VisitPlanController(HotelService hotelService, RestaurantService restaurantService, StoreService storeService) {
        this.hotelService = hotelService;
        this.restaurantService = restaurantService;
        this.storeService = storeService;
    }

    @GetMapping("/planifica-tu-visita")
    public String mostrarHoteles(Model model) {
        List<Hotel> hoteles = hotelService.getAllHotels();
        List<Restaurant> restaurantes = restaurantService.getAllRestaurants();
        List<Store> tiendas = storeService.getAllStores();

        model.addAttribute("hoteles", hoteles);
        model.addAttribute("restaurantes", restaurantes);
        model.addAttribute("tiendas", tiendas);
        return "PlanificaTuVisita";
    }
}