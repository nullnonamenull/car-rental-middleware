package com.poleszak.carmanagementservice.repository;

import com.poleszak.carmanagementservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByName(String name);
}
