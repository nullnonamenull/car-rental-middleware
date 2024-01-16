package com.poleszak.carmanagementservice.service.tools.validator;

import com.poleszak.carmanagementservice.common.exception.CustomServiceException;
import com.poleszak.carmanagementservice.common.exception.ErrorCode;
import com.poleszak.carmanagementservice.controller.command.CarGroupCreationRequest;
import com.poleszak.carmanagementservice.repository.CarGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CarGroupValidator {

    private final CarGroupRepository carGroupRepository;


    public void validateCarGroupRequestCreation(CarGroupCreationRequest carGroupCreationRequest) {
        log.info("CarGroupValidator::Validation process of carGroupCreationRequest: {}", carGroupCreationRequest);
        carGroupRepository.findCarGroupByName(carGroupCreationRequest.name())
                .orElseThrow(() ->
                        new CustomServiceException(
                                HttpStatus.CONFLICT,
                                ErrorCode.CAR_GROUP_WITH_NAME_ALREADY_EXIST.getMessage()));
    }
}