package com.example.FoodDelivery.repository;

import com.example.FoodDelivery.model.Restaurant;
import com.example.FoodDelivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{
   List<Restaurant> findByNumeContaining(String nume);
}
