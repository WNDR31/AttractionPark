// ThrillRepository.java
package com.example.demo.repository;

import com.example.demo.entity.Thrill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ThrillRepository extends JpaRepository<Thrill, Long> {
    List<Thrill> findAllByOrderByNameAsc();
    Thrill findByName(String name);
}