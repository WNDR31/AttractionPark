package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Thrill;

@Repository
public interface ThrillRepository extends JpaRepository<Thrill, Long> {
}
