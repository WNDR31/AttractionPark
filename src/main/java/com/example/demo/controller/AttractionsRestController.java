package com.example.demo.controller;

import com.example.demo.entity.Attraction;
import com.example.demo.services.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/attractions")
public class AttractionsRestController {

    private final AttractionService attractionService;

    @Autowired
    public AttractionsRestController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping
    public List<Attraction> getAll() {
        return attractionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attraction> getById(@PathVariable Long id) {
        return attractionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Attraction> create(@RequestBody Attraction attraction) {
        Attraction saved = attractionService.save(attraction);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attraction> update(@PathVariable Long id, @RequestBody Attraction attraction) {
        if (!attractionService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        attraction.setId(id);
        return ResponseEntity.ok(attractionService.save(attraction));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Attraction> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(attractionService.updatePartial(id, updates));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        attractionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}