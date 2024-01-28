package com.poleszak.carmanagementservice.service.tools.validator;

import com.poleszak.carmanagementservice.common.exception.CustomServiceException;
import com.poleszak.carmanagementservice.controller.command.request.CarGroupCreationRequest;
import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.repository.CarGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.poleszak.carmanagementservice.common.exception.ErrorCode.CAR_GROUP_NAME_ALREADY_EXISTS;

@Slf4j
@Component
@RequiredArgsConstructor
public class CarGroupValidator {

    private final CarGroupRepository carGroupRepository;


    public void validateCarGroupRequestCreation(CarGroupCreationRequest carGroupCreationRequest) {
        String carGroupName = carGroupCreationRequest.name();
        log.info("CarGroupValidator::Starting validation for CarGroupCreationRequest with name: {}", carGroupName);

        Optional<CarGroup> optionalCarGroup = carGroupRepository.findCarGroupByName(carGroupName);

        if (optionalCarGroup.isPresent()) {
            throw new CustomServiceException(CAR_GROUP_NAME_ALREADY_EXISTS);
        }
        log.info("CarGroupValidator::Validation successful for CarGroupCreationRequest with name: {}", carGroupName);
    }
}