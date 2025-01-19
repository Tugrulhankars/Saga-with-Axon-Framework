package com.example.orderservice.saga;

import com.example.common.commands.*;
import com.example.common.events.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import java.util.Random;

@Saga
public class OrderSaga {

    private final transient CommandGateway commandGateway;

    public OrderSaga(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    private void handle(OrderCreatedEvent event){
        Random random=new Random();
        Long paymentId= random.nextLong();

        SagaLifecycle.associateWith("paymentId",paymentId);

        CompletePaymentCommand command=new CompletePaymentCommand();
        command.setOrderId(event.getOrderId());
        command.setPaymentId(paymentId);
        command.setPrice(event.getPrice());
        command.setUserId(event.getUserId());

        commandGateway.send(command);
    }


    @SagaEventHandler(associationProperty = "paymentId")
    private void handle(PaymentCompletedEvent event){
        if (event.getPaymentStatus().equalsIgnoreCase("ERROR")){
            cancelOrderCommand(event.getOrderId());
        }else {
            Random random=new Random();
            Long shipmentId=random.nextLong();

            SagaLifecycle.associateWith("shipmentId",shipmentId);

            CompleteCargoCommand command=new CompleteCargoCommand(
                    shipmentId,
                    event.getOrderId(),
                    event.getUserId(),
                    event.getPaymentId(),
                    event.getPaymentStatus()
            );

            commandGateway.send(command);
        }

    }

    private void cancelOrderCommand(Long  orderId){
        CancelOrderCommand command=new CancelOrderCommand(orderId);
        commandGateway.send(command);
    }

    private void cancelPaymentCommand(OrderCompletedEvent event){
        CancelPaymentCommand cancelPaymentCommand=new CancelPaymentCommand(
                event.getPaymentId(),
                event.getOrderId()
        );
        commandGateway.send(cancelPaymentCommand);
    }

    @SagaEventHandler(associationProperty = "shipmentId")
    public void handle(OrderCompletedEvent event){

        if (event.getShipmentStatus().equalsIgnoreCase("ERROR")){
            cancelPaymentCommand(event);
        }else {

            CompleteOrderCommand completeOrderCommand=new CompleteOrderCommand(
                    event.getOrderId()
            );
            commandGateway.send(completeOrderCommand);
        }
    }

    @SagaEventHandler(associationProperty = "orderId")
    @EndSaga
    public void handle(CompleteOrderEvent event){
        System.out.println("Order is completed");
    }

    @SagaEventHandler(associationProperty = "orderId")
    @EndSaga
    public void handle(OrderCanceledEvent event){
        System.out.println("Order is canceled");
    }
}
