package com.poleszak.carmanagementservice.controller.command;

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
@RequestMapping("api/car-group")
@RequiredArgsConstructor
public class CarGroupCommandController {

    private final CarGroupCommandService carGroupCommandService;


    @PostMapping
    public ResponseEntity<URI> createCarGroup(@RequestBody CarGroupCreationRequest carGroupCreationRequest) {
        log.info("New car group creation {}", carGroupCreationRequest);
        URI createdCarGroupUri = carGroupCommandService.createCarGroup(carGroupCreationRequest);

        return ResponseEntity.created(createdCarGroupUri).build();
    }
}
