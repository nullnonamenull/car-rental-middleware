package com.poleszak.carmanagementservice.controller.command;

import com.poleszak.carmanagementservice.model.Car;

import java.util.List;

public record CarGroupCreationRequest(
        String name,
        List<Car> cars
) {
}