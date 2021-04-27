package com.example.FoodDelivery.repository;

import com.example.FoodDelivery.model.MenuItem;
import com.example.FoodDelivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long>{
   List<MenuItem> findByName(String nume);
}
