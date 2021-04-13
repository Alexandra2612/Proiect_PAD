package com.example.FoodDelivery.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.FoodDelivery.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{
   List<User> findByEmail(String email);
}
