package com.example.orderservice.aggregate;

import com.example.common.commands.CancelOrderCommand;
import com.example.common.commands.CompleteOrderCommand;
import com.example.common.commands.CreateOrderCommand;
import com.example.common.events.OrderCanceledEvent;
import com.example.common.events.CompleteOrderEvent;
import com.example.common.events.OrderCreatedEvent;
import com.example.orderservice.handler.OrderEventHandler;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private Long orderId;
    @Autowired
    private  OrderEventHandler orderEventHandler;



    public OrderAggregate() {

    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand){

        OrderCreatedEvent orderCreateEvent=new OrderCreatedEvent(
                createOrderCommand.getOrderId(),
                createOrderCommand.getProductId(),
                createOrderCommand.getUserId(),
                createOrderCommand.getQuantity(),
                createOrderCommand.getPrice(),
                createOrderCommand.getOrderStatus()
        );

        AggregateLifecycle.apply(orderCreateEvent);
    }

    @CommandHandler
    public void handle(CompleteOrderCommand completeOrderCommand){

        CompleteOrderEvent event=new CompleteOrderEvent(
                completeOrderCommand.getOrderId(),
                completeOrderCommand.getOrderStatus()
        );

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void  handle(CancelOrderCommand cancelOrderCommand){

        OrderCanceledEvent event=new OrderCanceledEvent();
        event.setOrderId(cancelOrderCommand.getOrderId());
        event.setOrderStatus("CANCELED");
        AggregateLifecycle.apply(event);

    }

    @EventSourcingHandler
    public void on(CompleteOrderEvent event){
        this.orderId=event.getOrderId();
        orderEventHandler.on(event);
    }

    @EventSourcingHandler
    public void on(OrderCanceledEvent event){
        this.orderId=event.getOrderId();
        orderEventHandler.on(event);
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event){
        this.orderId=event.getOrderId();
        orderEventHandler.on(event);
    }



}
