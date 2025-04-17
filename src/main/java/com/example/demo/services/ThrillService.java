package com.example.demo.services;

import com.example.demo.entity.Thrill;
import com.example.demo.repository.ThrillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThrillService {

    private final ThrillRepository thrillRepository;

    @Autowired
    public ThrillService(ThrillRepository thrillRepository) {
        this.thrillRepository = thrillRepository;
    }

    public List<Thrill> findAll() {
        return thrillRepository.findAllByOrderByNameAsc();
    }

    public Optional<Thrill> findById(Long id) {
        return thrillRepository.findById(id);
    }

    public Thrill save(Thrill thrill) {
        return thrillRepository.save(thrill);
    }

    public void deleteById(Long id) {
        thrillRepository.deleteById(id);
    }

    public Optional<Thrill> findByName(String name) {
        return thrillRepository.findByName(name);
    }
}
