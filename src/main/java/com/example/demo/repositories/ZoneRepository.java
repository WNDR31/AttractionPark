package com.example.demo.repositories;

import com.example.demo.entities.Zone;  // Asegúrate de importar correctamente Zone
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
}
