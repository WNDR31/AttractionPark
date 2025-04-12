package com.example.demo.services;

import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Transactional
    public Hotel updateHotel(Long id, Map<String, Object> updates) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();

            updates.forEach((key, value) -> {
                switch (key) {
                    case "name" -> hotel.setName((String) value);
                    case "description" -> hotel.setDescription((String) value);
                    case "theme" -> hotel.setTheme((String) value);
                    case "roomTypes" -> hotel.setRoomTypes((String) value);
                    case "stars" -> hotel.setStars((String) value); // stars is String now
                    case "coverImage" -> hotel.setCoverImage((String) value);
                    case "url" -> hotel.setUrl((String) value);
                }
            });
            return hotelRepository.save(hotel);
        } else {
            throw new RuntimeException("Hotel not found");
        }
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new RuntimeException("Hotel not found with ID: " + id);
        }
        hotelRepository.deleteById(id);
    }
}