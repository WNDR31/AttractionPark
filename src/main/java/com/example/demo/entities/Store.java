
package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String productType; // Type of products sold (e.g., electronics, clothing, etc.)
    private String location; // Location of the store (e.g., city, mall)
    private String coverImage; // Cover image of the store

    // Default constructor
    public Store() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCoverImage() { return coverImage; }
    public void setCoverImage(String coverImage) { this.coverImage = coverImage; }
}
