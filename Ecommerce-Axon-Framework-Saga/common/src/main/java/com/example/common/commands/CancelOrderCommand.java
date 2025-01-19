package com.example.common.commands;

import com.example.common.enums.ORDER_STATUS;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CancelOrderCommand {

    @TargetAggregateIdentifier
    private final Long orderId;
    private String ordrStatus= ORDER_STATUS.CANCELLED.toString();

    public CancelOrderCommand(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }
}
