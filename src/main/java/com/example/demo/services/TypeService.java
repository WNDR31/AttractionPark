package com.example.demo.services;

import com.example.demo.entity.Type;
import com.example.demo.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> findAll() {
        return typeRepository.findAllByOrderByNameAsc();
    }

    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }

    public Type save(Type type) {
        return typeRepository.save(type);
    }

    public void deleteById(Long id) {
        typeRepository.deleteById(id);
    }

    public Optional<Type> findByName(String name) {
        return typeRepository.findByName(name);  
        
    }
}
