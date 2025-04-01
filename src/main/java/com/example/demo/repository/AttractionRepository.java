package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Attraction;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
}
