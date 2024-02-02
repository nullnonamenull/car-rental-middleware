package com.poleszak.carmanagementservice.controller.command;

import com.poleszak.carmanagementservice.controller.command.request.CarGroupCreationRequest;
import com.poleszak.carmanagementservice.service.command.CarGroupCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("api/command/car-group")
@RequiredArgsConstructor
public class CarGroupCommandController {

    private final CarGroupCommandService carGroupCommandService;


    @PostMapping
    public ResponseEntity<URI> createCarGroup(@RequestBody CarGroupCreationRequest carGroupCreationRequest) {
        String carGroupName = carGroupCreationRequest.name();
        log.info("CarGroupCommandController::Received request to create new car group with name: {}", carGroupName);

        URI createdCarGroupUri = carGroupCommandService.createCarGroup(carGroupCreationRequest);
        log.info("CarGroupCommandController::Successfully created car group with name: {}. Resource URI: {}", carGroupName, createdCarGroupUri);

        return ResponseEntity.created(createdCarGroupUri).build();
    }
}