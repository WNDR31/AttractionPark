package com.example.demo.repository;

import com.example.demo.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {
    List<Type> findAllByOrderByNameAsc();
    Optional<Type> findByName(String name);
}
