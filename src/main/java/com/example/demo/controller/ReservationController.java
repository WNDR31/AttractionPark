package com.example.demo.controller;

import com.example.demo.entity.Reservation;
import com.example.demo.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        log.info("Recibida solicitud para crear reserva: {}", reservation);
        try {
            Reservation savedReservation = reservationService.createReservation(reservation);
            log.info("Reserva creada y guardada con ID: {}", savedReservation.getId());
            return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al crear reserva: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear la reserva", e);
        }
    }
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        log.info("Solicitud para obtener todas las reservas");
        List<Reservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        log.info("Solicitud para obtener reserva con ID: {}", id);
        Optional<Reservation> reservationOptional = reservationService.getReservationById(id);

        return reservationOptional
                .map(reservation -> new ResponseEntity<>(reservation, HttpStatus.OK))
                .orElseThrow(() -> {
                    log.warn("Reserva no encontrada con ID: {}", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada con ID: " + id);
                });
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        log.info("Recibida solicitud PATCH para actualizar reserva con ID: {} con datos: {}", id, updates);
        try {
            Reservation updatedReservation = reservationService.updateReservation(id, updates);
            log.info("Reserva actualizada con ID: {}", updatedReservation.getId());
            return ResponseEntity.ok(updatedReservation);
        } catch (RuntimeException e) { 
            log.error("Error al actualizar reserva con ID {}: {}", id, e.getMessage());
            if (e.getMessage().contains("not found")) {
                 throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
            }
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar la reserva", e);
        } catch (Exception e) { 
             log.error("Error inesperado al actualizar reserva con ID {}: {}", id, e.getMessage());
             throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error inesperado al actualizar la reserva", e);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        log.info("Recibida solicitud para borrar reserva con ID: {}", id);
        try {
            reservationService.deleteReservation(id);
            log.info("Reserva borrada con ID: {}", id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) { 
            log.error("Error al borrar reserva con ID {}: {}", id, e.getMessage());
             if (e.getMessage().contains("not found")) {
                 throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
            }
             throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al borrar la reserva", e);
        } catch (Exception e) { 
             log.error("Error inesperado al borrar reserva con ID {}: {}", id, e.getMessage());
             throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error inesperado al borrar la reserva", e);
        }
    }
}