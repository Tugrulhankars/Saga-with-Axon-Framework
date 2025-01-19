package com.example.paymentservice.aggregate;

import com.example.common.commands.CancelPaymentCommand;
import com.example.common.commands.CompletePaymentCommand;
import com.example.common.events.PaymentCanceledEvent;
import com.example.common.events.PaymentCompletedEvent;
import com.example.paymentservice.handler.PaymentEventHandler;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class PaymentAggregate {

    @AggregateIdentifier
    private Long paymentId;

    @CommandHandler
    public PaymentAggregate(CompletePaymentCommand command){
        PaymentCompletedEvent event=new PaymentCompletedEvent();
        event.setPaymentId(command.getPaymentId());
        event.setPaymentStatus(command.getPaymentStatus());
        event.setPrice(command.getPrice());
        event.setUserId(command.getUserId());
        event.setOrderId(command.getOrderId());

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(CancelPaymentCommand command){
        PaymentCanceledEvent event =new PaymentCanceledEvent();
        event.setPaymentId(command.getPaymentId());
        event.setPaymentStatus(command.getPaymentStatus());
        event.setPrice(command.getPrice());
        event.setUserId(command.getUserId());
        event.setOrderId(command.getOrderId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(PaymentCompletedEvent event, PaymentEventHandler handler){
        this.paymentId=event.getPaymentId();
        handler.on(event);
    }

    @EventSourcingHandler
    public void on(PaymentCanceledEvent event, PaymentEventHandler handler){
        this.paymentId=event.getPaymentId();
        handler.on(event);
    }
}
