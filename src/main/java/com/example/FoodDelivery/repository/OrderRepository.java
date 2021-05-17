package com.example.FoodDelivery.repository;

import com.example.FoodDelivery.model.Order;
import com.example.FoodDelivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long>{
   List<Order> findByClient(String client);
   List<Order> findByRestaurant(String restaurant);
   List<Order> findByLivrator(String livrator);
}
