package com.example.paymentservice.repository;

import com.example.paymentservice.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface PaymentRepository extends MongoRepository<Payment,Long> {
    Payment findByPaymentId(Long paymentId);
}
