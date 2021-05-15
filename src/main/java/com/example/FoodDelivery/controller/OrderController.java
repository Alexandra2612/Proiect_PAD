package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.Order;
import com.example.FoodDelivery.repository.OrderRepository;
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
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam(required = false) Long clientId, @RequestParam(required = false) Long livratorId, @RequestParam(required = false) Long restaurantId) {
        try {
            List<Order> orders = new ArrayList<Order>();
            if(clientId==null && livratorId==null && restaurantId==null)
                orderRepository.findAll().forEach(orders::add);
            else if(clientId!=null)
                orderRepository.findByClientId(clientId).forEach(orders::add);
            else if(livratorId!=null)
                orderRepository.findByLivratorId(livratorId).forEach(orders::add);
            else if(restaurantId!=null)
                orderRepository.findByRestaurantId(restaurantId).forEach(orders::add);

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long id) {
        Optional<Order> orderData = orderRepository.findById(id);

        if (orderData.isPresent()) {
            return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order _order = orderRepository
                    .save(new Order(order.getClientId(),order.getLivratorId(),order.getRestaurantId(),order.getContinut(),order.getPrettotal(),order.getMetodaplata(),order.getAdresa()));
            return new ResponseEntity<>(_order, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestBody Order order) {
        Optional<Order> orderData = orderRepository.findById(id);

        if (orderData.isPresent()) {
            Order _order = orderData.get();
            _order.setClientId(order.getClientId());
            _order.setLivratorId(order.getLivratorId());
            _order.setRestaurantId(order.getRestaurantId());
            _order.setContinut(order.getContinut());
            _order.setPrettotal(order.getPrettotal());
            _order.setMetodaplata(order.getMetodaplata());
            _order.setAdresa(order.getAdresa());
            _order.setFinished(order.getFinished());
            return new ResponseEntity<>(orderRepository.save(_order), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") long id) {
        try {
            orderRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/order/clientId")
    public ResponseEntity<List<Order>> findByClientId(long clientId) {
        try {
            List<Order> orders = orderRepository.findByClientId(clientId);

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/order/restaurantId")
    public ResponseEntity<List<Order>> findByRestaurantId(long restaurantId) {
        try {
            List<Order> orders = orderRepository.findByRestaurantId(restaurantId);

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/order/livratorId")
    public ResponseEntity<List<Order>> findByLivratorId(long livratorId) {
        try {
            List<Order> orders = orderRepository.findByLivratorId(livratorId);

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
