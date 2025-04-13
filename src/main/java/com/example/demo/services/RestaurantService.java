package com.example.demo.services;

import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public Restaurant updateRestaurant(Long id, Map<String, Object> updates) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();

            updates.forEach((key, value) -> {
                switch (key) {
                    case "name" -> restaurant.setName((String) value);
                    case "slogan" -> restaurant.setSlogan((String) value);
                    case "theme" -> restaurant.setTheme((String) value);
                    case "diningType" -> restaurant.setDiningType((String) value);
                    case "location" -> restaurant.setLocation((String) value);
                    case "coverImage" -> restaurant.setCoverImage((String) value);
                }
            });
            return restaurantRepository.save(restaurant);
        } else {
            throw new RuntimeException("Restaurant not found");
        }
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public void deleteRestaurant(Long id) {
        if (!restaurantRepository.existsById(id)) {
            throw new RuntimeException("Restaurant not found with ID: " + id);
        }
        restaurantRepository.deleteById(id);
    }
}