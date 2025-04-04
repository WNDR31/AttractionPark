package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Changed to Long for primary key
    private String name;
    private String surname;
    private String phone;
    private LocalDate date;
    private String email;
    private String entryType;
    private int quantity;

    public Reservation() {}

    public Reservation(String n, String s, String p, LocalDate d, String e, String t, int c) {
        name = n;
        surname = s;
        phone = p;
        date = d;
        email = e;
        entryType = t;
        quantity = c;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String tipoEntrada) {
        this.entryType = tipoEntrada;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int cantidad) {
        this.quantity = cantidad;
    }


    // toString method
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", date=" + date +
                ", email='" + email + '\'' +
                ", tipoEntrada='" + entryType + '\'' +
                ", cantidad=" + quantity +
                '}';
    }
}


