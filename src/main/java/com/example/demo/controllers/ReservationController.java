package com.example.demo.controllers;

import com.example.demo.entity.Reservation;
import com.example.demo.services.ReservationService; // ¡IMPORTA EL SERVICIO!

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController // ¡CORRECTO PARA API REST!
@RequestMapping("/reservations") // ¡CORRECTO!
public class ReservationController {

    private final ReservationService reservationService; // ¡USA EL SERVICIO, NO EL REPOSITORIO DIRECTAMENTE!
    private Logger log = LoggerFactory.getLogger(ReservationController.class);

    // **CONSTRUCTOR PARA INYECTAR EL SERVICIO (¡IMPORTANTE!)**
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping // **¡CORRECTO! POST PARA CREAR UNA NUEVA RESERVA**
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){ // **¡@RequestBody PARA RECIBIR DATOS JSON EN EL CUERPO DE LA SOLICITUD!**
        log.info("Recibida solicitud para crear reserva: {}", reservation); // Log más informativo
        Reservation savedReservation = reservationService.createReservation(reservation); // **¡USA EL SERVICIO PARA GUARDAR!**
        log.info("Reserva creada y guardada con ID: {}", savedReservation.getId()); // Log más informativo
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED); // **¡CORRECTO! DEVUELVE LA RESERVA CREADA Y CÓDIGO 201 CREATED**
    }


    // PATCH para actualización parcial (ESTO ESTÁ BIEN, LO DEJO COMO ESTABA COMENTADO PERO LO DESCOMENTARÉ)
    @PatchMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Reservation updatedReservation = reservationService.updateReservation(id, updates);
        return ResponseEntity.ok(updatedReservation);
    }

    /* **PUEDES AÑADIR ENDPOINTS GET PARA OBTENER RESERVAS SI QUIERES (EJEMPLO):**
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = Optional.ofNullable(reservationService.getReservationById(id)); // Suponiendo que tienes un método getReservationById en tu servicio
        if (reservation.isPresent()) {
            return ResponseEntity.ok(reservation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        */

}