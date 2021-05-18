package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.Restaurant;
import com.example.FoodDelivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/api")
public class RestaurantController {
    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping("/restaurant")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(@RequestParam(required = false) String nume) {
        try {
            List<Restaurant> restaurants = new ArrayList<Restaurant>();

            if (nume == null)
                restaurantRepository.findAll().forEach(restaurants::add);
            else
                restaurantRepository.findByNumeContaining(nume).forEach(restaurants::add);

            if (restaurants.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") long id) {
        Optional<Restaurant> restaurantData = restaurantRepository.findById(id);

        if (restaurantData.isPresent()) {
            return new ResponseEntity<>(restaurantData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/restaurant")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        try {
            Restaurant _restaurant = restaurantRepository
                    .save(new Restaurant(restaurant.getNume(),restaurant.getImagine(),restaurant.getAdresa(),restaurant.getDescriere(),restaurant.getMeniu()));
            return new ResponseEntity<>(_restaurant, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/restaurant/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") long id, @RequestBody Restaurant restaurant) {
        Optional<Restaurant> restaurantData = restaurantRepository.findById(id);

        if (restaurantData.isPresent()) {
            Restaurant _restaurant = restaurantData.get();
            _restaurant.setNume(restaurant.getNume());
            _restaurant.setImagine(restaurant.getImagine());
            _restaurant.setAdresa(restaurant.getAdresa());
            _restaurant.setDescriere(restaurant.getDescriere());
            _restaurant.setMeniu(restaurant.getMeniu());
            return new ResponseEntity<>(restaurantRepository.save(_restaurant), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<HttpStatus> deleteRestaurant(@PathVariable("id") long id) {
        try {
            restaurantRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/restaurant/nume")
    public ResponseEntity<List<Restaurant>> findByNumeContaining(String nume) {
        try {
            List<Restaurant> restaurants = restaurantRepository.findByNumeContaining(nume);

            if (restaurants.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
