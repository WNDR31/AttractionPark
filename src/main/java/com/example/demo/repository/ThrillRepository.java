package com.example.demo.repository;

import com.example.demo.entity.Thrill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ThrillRepository extends JpaRepository<Thrill, Long> {
    List<Thrill> findAllByOrderByNameAsc();
    Optional<Thrill> findByName(String name);
}
