package com.example.cargoservice.handler;

import com.example.cargoservice.model.Cargo;
import com.example.cargoservice.repository.CargoRepository;
import com.example.common.events.OrderCompletedEvent;
import org.springframework.stereotype.Component;

@Component
public class CargoEventHandler {

    private final CargoRepository cargoRepository;

    public CargoEventHandler(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void on(OrderCompletedEvent event)  {

        Cargo cargo=new Cargo();

        if (event.getUserId().equals(4)){
            throw new RuntimeException("UserId cannot be empty");
        }
        cargo.setOrderId(event.getOrderId());
        cargo.setPaymentId(event.getPaymentId());
        cargo.setCargoId(event.getCargoId());
        cargo.setCargoStatus(event.getShipmentStatus());
        cargo.setUserId(event.getUserId());

        cargoRepository.save(cargo);

    }
}
