package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Attraction;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
}
