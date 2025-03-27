package com.example.demo.repositories;

import com.example.demo.entities.Thrill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThrillRepository extends JpaRepository<Thrill, Long> {
}
