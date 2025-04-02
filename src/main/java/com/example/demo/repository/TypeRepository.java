// TypeRepository.java
package com.example.demo.repository;

import com.example.demo.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    List<Type> findAllByOrderByNameAsc();
    Type findByName(String name);
}