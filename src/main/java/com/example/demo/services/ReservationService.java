package com.example.demo.services;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;
import java.util.List;

import java.time.LocalDate;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    /*
    //Crear una nueva reserva
    public Reservation createReservation(Reservation reservation) {
       return reservationRepository.save(reservation); // Usa el repositorio para guardar la entidad
    }
    
    */
    public Reservation createReservation(Reservation reservation) {
        System.out.println("**** ReservationService.createReservation() INICIADO ****"); // LOG ANTES DE GUARDAR
        Reservation savedReservation = reservationRepository.save(reservation);
        System.out.println("**** ReservationService.createReservation() RESERVACIÓN GUARDADA: " + savedReservation); // LOG DESPUÉS DE GUARDAR
        System.out.println("**** ReservationService.createReservation() FINALIZADO ****"); // LOG AL FINAL
        return savedReservation;
    }

    // Actualización parcial con PATCH
    @Transactional
    public Reservation updateReservation(Long id, Map<String, Object> updates) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();

            updates.forEach((key, value) -> {
                switch (key) {
                    case "name" -> reservation.setName((String) value);
                    case "surname" -> reservation.setSurname((String) value);
                    case "phone" -> reservation.setPhone((String) value);
                    case "date" -> reservation.setDate(LocalDate.parse((String) value));
                    case "email" -> reservation.setEmail((String) value);
                    case "entryType" -> reservation.setEntryType((String) value);
                    case "quantity" -> reservation.setQuantity((Integer) value);
                }
            });

            return reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("Reservation not found");
        }
    }
    //Metodo para obtener todas las reservas
    public List<Reservation> getAllReservations() {
        System.out.println("**** ReservationService.getAllReservations() INICIADO ****"); // Log al inicio
        List<Reservation> allReservations = reservationRepository.findAll(); // Usa findAll() del repositorio
        System.out.println("**** ReservationService.getAllReservations() RESERVACIONES ENCONTRADAS: " + allReservations.size()); // Log con la cantidad
        System.out.println("**** ReservationService.getAllReservations() FINALIZADO ****"); // Log al final
        return allReservations;
    }

    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Reservation not found with ID: " + id);
        }
        reservationRepository.deleteById(id);
    }
}