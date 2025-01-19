package com.example.common.commands;

import com.example.common.enums.ORDER_STATUS;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CompleteOrderCommand {

    @TargetAggregateIdentifier
    private final Long orderId;
    private String orderStatus= ORDER_STATUS.ORDERED.toString();

    public CompleteOrderCommand(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }
}
