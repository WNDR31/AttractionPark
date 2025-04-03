package com.example.demo.controllers;

import com.example.demo.entity.Reservation;
import com.example.demo.services.ReservationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List; 

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservations")

public class ReservationController {

    private final ReservationService reservationService;
    private Logger log = LoggerFactory.getLogger(ReservationController.class);

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        log.info("Recibida solicitud para crear reserva: {}", reservation);
        Reservation savedReservation = reservationService.createReservation(reservation);
        log.info("Reserva creada y guardada con ID: {}", savedReservation.getId());
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Reservation updatedReservation = reservationService.updateReservation(id, updates);
        return ResponseEntity.ok(updatedReservation);
    }
    @GetMapping 
    public ResponseEntity<List<Reservation>> getAllReservations() {
        log.info("Solicitud para obtener todas las reservas");
        List<Reservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK); 
    }
}