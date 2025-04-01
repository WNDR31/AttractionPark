package com.example.demo.services;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

import java.time.LocalDate;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
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
                }
            });

            return reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("Reservation not found");
        }
    }
}