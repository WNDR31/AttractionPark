package com.example.demo.controllers;

import com.example.demo.entities.Reservation;
import com.example.demo.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // PATCH para actualización parcial
    @PatchMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Reservation updatedReservation = reservationService.updateReservation(id, updates);
        return ResponseEntity.ok(updatedReservation);
    }
}
