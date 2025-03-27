package com.example.demo.entities;

import jakarta.persistence.*;

public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Getters and setters
}
