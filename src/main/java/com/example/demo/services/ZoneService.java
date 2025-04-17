package com.example.demo.services;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoneService {

    private final ZoneRepository zoneRepository;

    @Autowired
    public ZoneService(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    public List<Zone> findAll() {
        return zoneRepository.findAllByOrderByNameAsc();
    }

    public Optional<Zone> findById(Long id) {
        return zoneRepository.findById(id);
    }

    public Zone save(Zone zone) {
        return zoneRepository.save(zone);
    }

    public void deleteById(Long id) {
        zoneRepository.deleteById(id);
    }

    public Optional<Zone> findByName(String name) {
        return zoneRepository.findByName(name);
    }
}