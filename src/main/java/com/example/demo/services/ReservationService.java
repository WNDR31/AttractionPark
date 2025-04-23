package com.example.demo.services;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final TicketRepository ticketRepository; 

    public ReservationService(ReservationRepository reservationRepository, TicketRepository ticketRepository) {
        this.reservationRepository = reservationRepository;
        this.ticketRepository = ticketRepository;
    }

    public Reservation createReservation(Reservation reservation) {
        List<Ticket> managedTickets = reservation.getTickets().stream()
            .<Ticket>map(ticket -> ticketRepository.findById(ticket.getId())
                    .orElseThrow(() -> new RuntimeException("Ticket no encontrado con id: " + ticket.getId())))
            .collect(Collectors.toList());

        reservation.setTickets(managedTickets);

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