package com.example.demo.controller;

import com.example.demo.entity.Restaurant;
import com.example.demo.services.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/restaurants") 
public class RestaurantController {

    private final RestaurantService restaurantService;
    private Logger log = LoggerFactory.getLogger(RestaurantController.class);

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        log.info("Recibida solicitud para crear restaurante: {}", restaurant);
        Restaurant savedRestaurant = restaurantService.createRestaurant(restaurant);
        log.info("Restaurante creado y guardado con ID: {}", savedRestaurant.getId());
        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, updates);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        log.info("Solicitud para obtener todos los restaurantes");
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}