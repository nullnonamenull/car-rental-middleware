package com.poleszak.carmanagementservice.service.command;

import com.poleszak.carmanagementservice.controller.command.CarGroupCreationRequest;
import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.repository.CarGroupRepository;
import com.poleszak.carmanagementservice.service.tools.validator.CarGroupValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarGroupCommandService {


    private final CarGroupRepository carGroupRepository;
    private final CarGroupValidator carGroupValidator;

    public URI createCarGroup(CarGroupCreationRequest carGroupCreationRequest) {
        carGroupValidator.validateCarGroupRequestCreation(carGroupCreationRequest);

        CarGroup carGroup = CarGroup.builder()
                .name(carGroupCreationRequest.name())
                .cars(carGroupCreationRequest.cars())
                .build();

        log.info("CarGroupCommandService::Saving new car group: {}", carGroup);
        carGroupRepository.save(carGroup);
        return null;
    }
}
