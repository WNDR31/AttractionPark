

package com.example.demo.repository;

import com.example.demo.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    
    // Métodos existentes
    List<Attraction> findByZoneId(Long zoneId);
    List<Attraction> findByZoneName(String name);
    List<Attraction> findByTypeId(Long typeId);
    List<Attraction> findByTypeName(String name);
    List<Attraction> findByIntensityId(Long intensityId);
    List<Attraction> findByIntensityName(String name);
    
    // Consulta para filtros combinados
    @Query("SELECT a FROM Attraction a WHERE " +
           "(:zone IS NULL OR a.zone.name = :zone) AND " +
           "(:intensity IS NULL OR a.intensity.name = :intensity) AND " +
           "(:type IS NULL OR a.type.name = :type) " +
           "ORDER BY a.name ASC")
    List<Attraction> findByCombinedFilters(
        @Param("zone") String zone,
        @Param("intensity") String intensity,
        @Param("type") String type);
}