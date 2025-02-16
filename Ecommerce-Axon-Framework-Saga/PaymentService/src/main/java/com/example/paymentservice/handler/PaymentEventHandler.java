package com.example.paymentservice.handler;

import com.example.common.events.PaymentCanceledEvent;
import com.example.common.events.PaymentCompletedEvent;
import com.example.paymentservice.models.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventHandler {

    private final PaymentRepository paymentRepository;

    public PaymentEventHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void on(PaymentCompletedEvent event){

        if (event.getUserId().equals(4)) {
            throw new RuntimeException();
        }

        Payment payment=paymentRepository.findByPaymentId(event.getPaymentId());
        if (payment==null){
            payment = new Payment();
            payment.setOrderId(event.getOrderId());
            payment.setPaymentId(event.getPaymentId());
            payment.setPaymentStatus(event.getPaymentStatus());
            payment.setPrice(event.getPrice());
            payment.setUserId(event.getUserId());
            paymentRepository.save(payment);
        }



    }

    public void on(PaymentCanceledEvent event){
        Payment payment=paymentRepository.findByPaymentId(event.getPaymentId());
        payment.setPaymentStatus(event.getPaymentStatus());
        paymentRepository.save(payment);
    }
}
