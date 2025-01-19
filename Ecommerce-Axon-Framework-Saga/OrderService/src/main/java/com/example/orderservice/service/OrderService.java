package com.example.orderservice.service;

import com.example.common.commands.CreateOrderCommand;
import com.example.common.enums.ORDER_STATUS;
import com.example.orderservice.models.Order;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class OrderService {

    private final CommandGateway commandGateway;

    public OrderService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public String createOrder(Order order){
        Random random=new Random();
        Long orderId=random.nextLong();


        CreateOrderCommand command=new CreateOrderCommand(
                orderId,
                order.getProductId(),
                order.getUserId(),
                order.getQuantity(),
                order.getPrice(),
                ORDER_STATUS.ORDERED.toString()
        );

        Object result=commandGateway.sendAndWait(command);

        return "Your order has been initiated. Order# "+result;

    }
}
