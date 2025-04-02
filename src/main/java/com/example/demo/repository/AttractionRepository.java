package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.demo.entity.Attraction;

@Repository

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    // Métodos existentes para zona
    List<Attraction> findByZoneId(Long zoneId);
    List<Attraction> findByZoneName(String name);
    
    // Nuevos métodos para tipo
    List<Attraction> findByTypeId(Long typeId);
    List<Attraction> findByTypeName(String name);
    
    // Nuevos métodos para intensidad
    List<Attraction> findByIntensityId(Long intensityId);
    List<Attraction> findByIntensityName(String name);
}