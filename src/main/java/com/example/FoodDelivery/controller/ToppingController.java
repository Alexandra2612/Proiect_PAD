package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.Topping;
import com.example.FoodDelivery.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:62507")
@RestController
@RequestMapping("/api")
public class ToppingController {
    @Autowired
    ToppingRepository toppingRepository;

    @GetMapping("/topping")
    public ResponseEntity<List<Topping>> getAllToppings() {
        try {
            List<Topping> toppings = new ArrayList<Topping>();
            toppingRepository.findAll().forEach(toppings::add);
            if (toppings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(toppings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/topping/{id}")
    public ResponseEntity<Topping> getToppingById(@PathVariable("id") long id) {
        Optional<Topping> toppingData = toppingRepository.findById(id);

        if (toppingData.isPresent()) {
            return new ResponseEntity<>(toppingData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/topping")
    public ResponseEntity<Topping> createTopping(@RequestBody Topping topping) {
        try {
            Topping _topping = toppingRepository
                    .save(new Topping(topping.getNume(),topping.getPret(),topping.getGramaj()));
            return new ResponseEntity<>(_topping, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/topping/{id}")
    public ResponseEntity<Topping> updateTopping(@PathVariable("id") long id, @RequestBody Topping topping) {
        Optional<Topping> toppingData = toppingRepository.findById(id);

        if (toppingData.isPresent()) {
            Topping _topping = toppingData.get();
            _topping.setNume(topping.getNume());
            _topping.setPret(topping.getPret());
            _topping.setGramaj(topping.getGramaj());
            return new ResponseEntity<>(toppingRepository.save(_topping), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/topping/{id}")
    public ResponseEntity<HttpStatus> deleteTopping(@PathVariable("id") long id) {
        try {
            toppingRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
