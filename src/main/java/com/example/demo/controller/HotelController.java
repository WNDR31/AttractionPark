package com.example.demo.controller;

import com.example.demo.entity.Hotel;
import com.example.demo.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hotels") 
public class HotelController {

    private final HotelService hotelService;
    private Logger log = LoggerFactory.getLogger(HotelController.class);

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        log.info("Recibida solicitud para crear hotel: {}", hotel);
        Hotel savedHotel = hotelService.createHotel(hotel);
        log.info("Hotel creado y guardado con ID: {}", savedHotel.getId());
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Hotel updatedHotel = hotelService.updateHotel(id, updates);
        return ResponseEntity.ok(updatedHotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        log.info("Solicitud para obtener todos los hoteles");
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }
}