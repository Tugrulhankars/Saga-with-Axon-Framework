package com.example.orderservice.repository;

import com.example.orderservice.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface OrderRepository extends MongoRepository<Order,Long> {
    Order findByOrderId(Long orderId);
}
