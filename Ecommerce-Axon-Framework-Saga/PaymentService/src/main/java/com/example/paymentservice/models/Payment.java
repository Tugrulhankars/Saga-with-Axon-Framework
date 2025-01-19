package com.example.paymentservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
public class Payment {

    @Id
    private Long id;
    private Long paymentId;
    private Long orderId;
    private Long userId;
    private double price;
    private String paymentStatus;

    public Payment() {
    }

    public Payment(Long id, String paymentStatus, double price, Long userId, Long orderId, Long paymentId) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.price = price;
        this.userId = userId;
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
