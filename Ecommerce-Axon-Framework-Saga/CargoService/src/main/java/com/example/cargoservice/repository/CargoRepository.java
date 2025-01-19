package com.example.cargoservice.repository;

import com.example.cargoservice.model.Cargo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CargoRepository extends MongoRepository<Cargo, Long> {
    Cargo findByCargoId(Long cargoId);
}
