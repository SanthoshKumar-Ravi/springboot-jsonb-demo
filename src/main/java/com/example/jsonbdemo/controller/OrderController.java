package com.example.jsonbdemo.controller;
import com.example.jsonbdemo.entity.Order;
import com.example.jsonbdemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @PostMapping
    public Order createOrder(@RequestBody Map<String, Object> request) {
        String customerName = (String) request.get("customerName");
        Map<String, Object> metadata = (Map<String, Object>) request.get("metadata");
        Order order = new Order(customerName, metadata);
        return orderRepository.save(order);
    }
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}