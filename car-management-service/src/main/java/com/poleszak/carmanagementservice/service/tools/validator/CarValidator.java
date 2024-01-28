package com.poleszak.carmanagementservice.service.tools.validator;

import com.poleszak.carmanagementservice.common.exception.CustomServiceException;
import com.poleszak.carmanagementservice.controller.command.request.CarCreationRequest;
import com.poleszak.carmanagementservice.model.Car;
import com.poleszak.carmanagementservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.poleszak.carmanagementservice.common.exception.ErrorCode.CAR_GROUP_NAME_ALREADY_EXISTS;

@Slf4j
@Component
@RequiredArgsConstructor
public class CarValidator {

    private final CarRepository carRepository;

    public void validateCarCreationRequest(CarCreationRequest carCreationRequest, Long carGroupId) {
        String carName = carCreationRequest.name();
        log.info("CarGroupValidator::Starting validation for CarGroupCreationRequest with name: {}", carName);

        Optional<Car> optionalCar = carRepository.findByNameAndCarGroupId(carName, carGroupId);

        if (optionalCar.isPresent()) {
            throw new CustomServiceException(CAR_GROUP_NAME_ALREADY_EXISTS);
        }
        log.info("CarGroupValidator::Validation successful for CarGroupCreationRequest with name: {}", carName);
    }

}
