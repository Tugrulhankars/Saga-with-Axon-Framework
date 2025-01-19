package com.example.common.events;

public class CompleteOrderEvent {
    private Long orderId;
    private String orderStatus;

    public CompleteOrderEvent(Long orderId, String orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
