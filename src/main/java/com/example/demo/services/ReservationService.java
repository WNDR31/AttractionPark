package com.example.demo.services;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation) {
        // Podrías añadir validaciones aquí si es necesario antes de guardar
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Transactional
    public Reservation updateReservation(Long id, Map<String, Object> updates) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + id));

        updates.forEach((key, value) -> {
            switch (key) {
                case "name" -> reservation.setName((String) value);
                case "surname" -> reservation.setSurname((String) value);
                case "phone" -> reservation.setPhone((String) value);
                case "email" -> reservation.setEmail((String) value);
                default -> System.out.println("Campo ignorado en actualización PATCH: " + key);
            }
        });
        return reservationRepository.save(reservation);
    }
    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Reservation not found with ID: " + id);
        }
        reservationRepository.deleteById(id);
    }
}