package com.example.cargoservice.aggregate;

import com.example.cargoservice.handler.CargoEventHandler;
import com.example.common.commands.CompleteCargoCommand;
import com.example.common.events.OrderCompletedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CargoAggregate {

    @AggregateIdentifier
    private Long cargoId;

    public CargoAggregate(){}

    @CommandHandler
    public CargoAggregate(CompleteCargoCommand command){
        OrderCompletedEvent event=new OrderCompletedEvent();
        event.setOrderId(command.getOrderId());
        event.setPaymentId(command.getPaymentId());
        event.setShipmentStatus(command.getShipmentStatus());
        event.setUserId(command.getUserId());
        event.setCargoId(command.getCargoId());
        AggregateLifecycle.apply(event);
    }


    @EventSourcingHandler
    public void on(OrderCompletedEvent event, CargoEventHandler ch){
        this.cargoId=event.getCargoId();
        ch.on(event);
    }
}
