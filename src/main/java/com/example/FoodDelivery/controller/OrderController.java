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
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam(required = false) String client, @RequestParam(required = false) String livrator, @RequestParam(required = false) String restaurant) {
        try {
            List<Order> orders = new ArrayList<Order>();
            if(client==null && livrator==null && restaurant==null)
                orderRepository.findAll().forEach(orders::add);
            else if(client!=null)
                orderRepository.findByClient(client).forEach(orders::add);
            else if(livrator!=null)
                orderRepository.findByLivrator(livrator).forEach(orders::add);
            else if(restaurant!=null)
                orderRepository.findByRestaurant(restaurant).forEach(orders::add);

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
                    .save(new Order(order.getClient(),order.getLivrator(),order.getRestaurant(),order.getContinut(),order.getPrettotal(),order.getMetodaplata(),order.getAdresa()));
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
            _order.setClient(order.getClient());
            _order.setLivrator(order.getLivrator());
            _order.setRestaurant(order.getRestaurant());
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

    @GetMapping("/order/client")
    public ResponseEntity<List<Order>> findByClient(String client) {
        try {
            List<Order> orders = orderRepository.findByClient(client);

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/order/restaurant")
    public ResponseEntity<List<Order>> findByRestaurant(String restaurant) {
        try {
            List<Order> orders = orderRepository.findByRestaurant(restaurant);

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/order/livrator")
    public ResponseEntity<List<Order>> findByLivrator(String livrator) {
        try {
            List<Order> orders = orderRepository.findByLivrator(livrator);

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
