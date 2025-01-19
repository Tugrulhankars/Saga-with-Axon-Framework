package com.example.common.events;

public class OrderCreatedEvent {
    private Long orderId;
    private Long productId;
    private Long userId;
    private int quantity;
    private double price;
    private String orderStatus;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(Long orderId, Long productId, Long userId, int quantity, double price, String orderStatus) {
        this.orderId = orderId;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
        this.price = price;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
