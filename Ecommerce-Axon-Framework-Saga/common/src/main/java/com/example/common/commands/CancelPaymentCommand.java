package com.example.common.commands;

import com.example.common.enums.PAYMENT_STATUS;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CancelPaymentCommand {
    @TargetAggregateIdentifier
    private final Long paymentId;
    private Long orderId;
    private Long userId;
    private double price;
    private String paymentStatus= PAYMENT_STATUS.PENDING.toString();

    public CancelPaymentCommand(Long paymentId, Long orderId) {
        this.paymentId = paymentId;
        this.orderId = orderId;
    }

    public CancelPaymentCommand(Long paymentId) {
        this.paymentId = paymentId;
    }

    public CancelPaymentCommand(String paymentStatus, double price, Long userId, Long orderId, Long paymentId) {
        this.paymentStatus = paymentStatus;
        this.price = price;
        this.userId = userId;
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

    public Long getPaymentId() {
        return paymentId;
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
