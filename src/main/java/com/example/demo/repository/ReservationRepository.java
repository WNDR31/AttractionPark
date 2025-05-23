package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}