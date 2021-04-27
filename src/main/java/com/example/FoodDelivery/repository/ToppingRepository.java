package com.example.FoodDelivery.repository;

import com.example.FoodDelivery.model.Topping;
import com.example.FoodDelivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToppingRepository extends JpaRepository<Topping,Long>{
}
