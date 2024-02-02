package com.poleszak.carmanagementservice.controller.command;

import com.poleszak.carmanagementservice.controller.command.request.CarCreationRequest;
import com.poleszak.carmanagementservice.service.command.CarCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("api/command/car")
@RequiredArgsConstructor
public class CarCommandController {

    private final CarCommandService carCommandService;

    @PostMapping("/{carGroupId}")
    public ResponseEntity<URI> addCarToCarGroup(@RequestBody CarCreationRequest carCreationRequest, @PathVariable("carGroupId") Long carGroupId) {
        log.info("CarCommandController::Received request to add new car with name: {} to car group with id: {}", carCreationRequest.name(), carGroupId);

        URI createdCarUri = carCommandService.addCarToCarGroup(carCreationRequest, carGroupId);
        log.info("CarCommandController::Successfully added car with name: {}. Resource URI: {}", carCreationRequest.name(), createdCarUri);

        return ResponseEntity.created(createdCarUri).build();
    }
}
