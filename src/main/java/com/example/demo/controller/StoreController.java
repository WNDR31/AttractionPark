package com.example.demo.controller;

import com.example.demo.entity.Store;
import com.example.demo.services.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stores") // ¡Importante: RequestMapping para /stores!
public class StoreController {

    private final StoreService storeService;
    private Logger log = LoggerFactory.getLogger(StoreController.class);

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        log.info("Recibida solicitud para crear tienda: {}", store);
        Store savedStore = storeService.createStore(store);
        log.info("Tienda creada y guardada con ID: {}", savedStore.getId());
        return new ResponseEntity<>(savedStore, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Store updatedStore = storeService.updateStore(id, updates);
        return ResponseEntity.ok(updatedStore);
    }

    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {
        log.info("Solicitud para obtener todas las tiendas");
        List<Store> stores = storeService.getAllStores();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }
}