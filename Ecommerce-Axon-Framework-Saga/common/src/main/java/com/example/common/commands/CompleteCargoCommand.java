package com.example.common.commands;

import com.example.common.enums.SHIPPING_STATUS;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CompleteCargoCommand {

    @TargetAggregateIdentifier
    private final Long cargoId;
    private Long orderId;
    private Long userId;
    private Long paymentId;
    private String shipmentStatus= SHIPPING_STATUS.COMPLETE.toString();

    public CompleteCargoCommand(Long shipmentId) {
        this.cargoId = shipmentId;
    }

    public CompleteCargoCommand(Long shipmentId, Long orderId, Long userId, Long paymentId, String shipmentStatus) {
        this.cargoId = shipmentId;
        this.orderId = orderId;
        this.userId = userId;
        this.paymentId = paymentId;
        this.shipmentStatus = shipmentStatus;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public Long getShipmentId() {
        return cargoId;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
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

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
}
