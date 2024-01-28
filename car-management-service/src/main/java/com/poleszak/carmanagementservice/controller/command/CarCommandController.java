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
@RequestMapping("api/car")
@RequiredArgsConstructor
public class CarCommandController {

    private final CarCommandService carCommandService;

    @PostMapping("/{carGroupId}")
    public ResponseEntity<URI> createCarGroup(@RequestBody CarCreationRequest carCreationRequest, @PathVariable("carGroupId") Long carGroupId) {
        String carName = carCreationRequest.name();
        log.info("Received request to create new car with name: {}. For car group with id: {}", carName, carGroupId);

        URI createdCarGroupUri = carCommandService.createCarForCarGroup(carCreationRequest, carGroupId);
        log.info("Successfully created car with name: {}. Resource URI: {}", carName, createdCarGroupUri);

        return ResponseEntity.created(createdCarGroupUri).build();
    }
}
