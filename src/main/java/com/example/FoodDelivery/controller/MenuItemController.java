package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.MenuItem;
import com.example.FoodDelivery.repository.MenuItemRepository;
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
public class MenuItemController {
    @Autowired
    MenuItemRepository menuItemRepository;

    @GetMapping("/menuItem")
    public ResponseEntity<List<MenuItem>> getAllMenuItems(@RequestParam(required = false) String nume) {
        try {
            List<MenuItem> menuItems = new ArrayList<MenuItem>();

            if (nume == null)
                menuItemRepository.findAll().forEach(menuItems::add);
            else
                menuItemRepository.findByNume(nume).forEach(menuItems::add);

            if (menuItems.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(menuItems, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/menuItem/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable("id") long id) {
        Optional<MenuItem> menuItemData = menuItemRepository.findById(id);

        if (menuItemData.isPresent()) {
            return new ResponseEntity<>(menuItemData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/menuItem")
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
        try {
            MenuItem _menuItem = menuItemRepository
                    .save(new MenuItem(menuItem.getNume(),menuItem.getIngrediente(),menuItem.getImagine(),menuItem.getPret(),menuItem.getGramaj(),menuItem.getToppinguri()));
            return new ResponseEntity<>(_menuItem, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/menuItem/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable("id") long id, @RequestBody MenuItem menuItem) {
        Optional<MenuItem> menuItemData = menuItemRepository.findById(id);

        if (menuItemData.isPresent()) {
            MenuItem _menuItem = menuItemData.get();
            _menuItem.setNume(menuItem.getNume());
            _menuItem.setImagine(menuItem.getImagine());
            _menuItem.setGramaj(menuItem.getGramaj());
            _menuItem.setIngrediente(menuItem.getIngrediente());
            _menuItem.setPret(menuItem.getPret());
            _menuItem.setToppinguri(menuItem.getToppinguri());
            return new ResponseEntity<>(menuItemRepository.save(_menuItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/menuItem/{id}")
    public ResponseEntity<HttpStatus> deleteMenuItem(@PathVariable("id") long id) {
        try {
            menuItemRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/menuItem/nume")
    public ResponseEntity<List<MenuItem>> findByNume(String nume) {
        try {
            List<MenuItem> menuItems = menuItemRepository.findByNume(nume);

            if (menuItems.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(menuItems, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
