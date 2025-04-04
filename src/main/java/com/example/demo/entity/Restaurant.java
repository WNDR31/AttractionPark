package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String slogan;
    private String theme;
    private String diningType; // Type of restaurant (self-service, à la carte, etc.)
    private String location; // Location of the restaurant
    private String coverImage;

    public Restaurant() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSlogan() { return slogan; }
    public void setSlogan(String slogan) { this.slogan = slogan; }

    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }

    public String getDiningType() { return diningType; }
    public void setDiningType(String diningType) { this.diningType = diningType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCoverImage() { return coverImage; }
    public void setCoverImage(String coverImage) { this.coverImage = coverImage; }
}
