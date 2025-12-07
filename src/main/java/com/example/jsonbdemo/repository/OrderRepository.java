package com.example.jsonbdemo.repository;
import com.example.jsonbdemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Long> {}