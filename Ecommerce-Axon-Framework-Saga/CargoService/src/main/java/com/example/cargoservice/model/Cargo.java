package com.example.cargoservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cargo")
public class Cargo {

    @Id
    private Long cargoId;
    private Long paymentId;
    private Long orderId;
    private Long userId;
    private String cargoStatus;

    public Cargo() {
    }

    public Cargo(Long cargoId, String cargoStatus, Long paymentId, Long userId, Long orderId) {
        this.cargoId = cargoId;
        this.cargoStatus = cargoStatus;
        this.paymentId = paymentId;
        this.userId = userId;
        this.orderId = orderId;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
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

    public String getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(String cargoStatus) {
        this.cargoStatus = cargoStatus;
    }
}
