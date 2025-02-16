package com.example.common.events;

public class OrderCompletedEvent {
    private Long cargoId;
    private Long paymentId;
    private Long orderId;
    private Long userId;
    private String cargoStatus;

    public OrderCompletedEvent() {
    }

    public OrderCompletedEvent(Long shipmentId, Long paymentId, Long orderId, Long userId, String shipmentStatus) {
        this.cargoId = shipmentId;
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.userId = userId;
        this.cargoStatus = shipmentStatus;
    }


    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public String getShipmentStatus() {
        return cargoStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.cargoStatus = shipmentStatus;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
