package com.example.common.events;

public class PaymentCanceledEvent {
    private Long paymentId;
    private Long orderId;
    private Long userId;
    private double price;
    private String paymentStatus;

    public PaymentCanceledEvent() {
    }

    public PaymentCanceledEvent(Long paymentId, String paymentStatus, double price, Long orderId, Long userId) {
        this.paymentId = paymentId;
        this.paymentStatus = paymentStatus;
        this.price = price;
        this.orderId = orderId;
        this.userId = userId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


}
