package com.example.demo.services;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Transactional
    public Store updateStore(Long id, Map<String, Object> updates) {
        Optional<Store> optionalStore = storeRepository.findById(id);
        if (optionalStore.isPresent()) {
            Store store = optionalStore.get();

            updates.forEach((key, value) -> {
                switch (key) {
                    case "name" -> store.setName((String) value);
                    case "productType" -> store.setProductType((String) value);
                    case "location" -> store.setLocation((String) value);
                    case "coverImage" -> store.setCoverImage((String) value);
                }
            });
            return storeRepository.save(store);
        } else {
            throw new RuntimeException("Store not found");
        }
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public void deleteStore(Long id) {
        if (!storeRepository.existsById(id)) {
            throw new RuntimeException("Store not found with ID: " + id);
        }
        storeRepository.deleteById(id);
    }
}