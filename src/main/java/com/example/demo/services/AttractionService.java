package com.example.demo.services;

import com.example.demo.entity.Attraction;
import com.example.demo.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;

    @Autowired
    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> findAll() {
        return attractionRepository.findAll();
    }

    public Optional<Attraction> findById(Long id) {
        return attractionRepository.findById(id);
    }

    public Attraction save(Attraction attraction) {
        return attractionRepository.save(attraction);
    }

    public void deleteById(Long id) {
        attractionRepository.deleteById(id);
    }

    public List<Attraction> findByCombinedFilters(String zone, String intensity, String type) {
        return attractionRepository.findByCombinedFilters(zone, intensity, type);
    }

    @Transactional
    public Attraction updatePartial(Long id, Map<String, Object> updates) {
        Attraction attraction = attractionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attraction not found"));
        
        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    attraction.setName((String) value);
                    break;
                case "description":
                    attraction.setDescription((String) value);
                    break;
                case "height":
                    attraction.setHeight(Double.parseDouble(value.toString()));
                    break;
                // Add all other fields similarly
            }
        });
        
        return attractionRepository.save(attraction);
    }
}