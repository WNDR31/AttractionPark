package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.demo.entity.Attraction;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    // Encuentra atracciones por zona
    List<Attraction> findByZoneId(Long zoneId);
    
    // O si prefieres por nombre de zona:
    List<Attraction> findByZoneName(String zoneName);
}