package com.example.orderservice.handler;

import com.example.common.events.OrderCanceledEvent;
import com.example.common.events.CompleteOrderEvent;
import com.example.common.events.OrderCreatedEvent;
import com.example.orderservice.models.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderEventHandler {

    private final OrderRepository orderRepository;

    public OrderEventHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void on(OrderCreatedEvent event) {
        Order order=orderRepository.findByOrderId(event.getOrderId());
        if (order == null) {
            order=new Order();
            order.setOrderId(event.getOrderId());
            order.setOrderStatus(event.getOrderStatus());
            order.setPrice(event.getPrice());
            order.setProductId(event.getProductId());
            order.setQuantity(event.getQuantity());
            order.setUserId(event.getUserId());
            orderRepository.save(order);
        }
    }

    public void on(CompleteOrderEvent event){
         Order order=orderRepository.findByOrderId(event.getOrderId());
         if (order!=null){
             order.setOrderStatus(event.getOrderStatus());
             orderRepository.save(order);
         }
    }

    public void on(OrderCanceledEvent event){
        Order order=orderRepository.findByOrderId(event.getOrderId());
        if (order!=null){
            order.setOrderStatus(event.getOrderStatus());
            orderRepository.save(order);
        }
    }


}
