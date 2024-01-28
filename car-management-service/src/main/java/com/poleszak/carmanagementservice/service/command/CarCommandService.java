package com.poleszak.carmanagementservice.service.command;

import com.poleszak.carmanagementservice.common.exception.CustomServiceException;
import com.poleszak.carmanagementservice.common.exception.ErrorCode;
import com.poleszak.carmanagementservice.controller.command.request.CarCreationRequest;
import com.poleszak.carmanagementservice.model.Car;
import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.repository.CarGroupRepository;
import com.poleszak.carmanagementservice.repository.CarRepository;
import com.poleszak.carmanagementservice.service.tools.mapper.CarMapper;
import com.poleszak.carmanagementservice.service.tools.validator.CarValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarCommandService {

    private final CarRepository carRepository;
    private final CarGroupRepository carGroupRepository;
    private final CarMapper carMapper;
    private final CarValidator carValidator;

    public URI addCarToCarGroup(CarCreationRequest carCreationRequest, Long carGroupId) {
        log.info("Received request to add car with name: {} to car group with id: {}", carCreationRequest.name(), carGroupId);

        CarGroup carGroup = carGroupRepository.findById(carGroupId)
                .orElseThrow(() -> new CustomServiceException(ErrorCode.CAR_GROUP_NOT_FOUND));

        carValidator.validateCarCreationRequest(carCreationRequest, carGroupId);
        Car car = carMapper.carCreationRequestToCar(carCreationRequest);
        car.setCarGroup(carGroup);

        Car savedCar = carRepository.save(car);

        URI createdCarUri = generateCarUri(savedCar.getId());
        log.info("New car added with URI: {}", createdCarUri);

        return createdCarUri;
    }


    private URI generateCarUri(Long carId) {
        return UriComponentsBuilder.fromPath("/api/car/{id}")
                .buildAndExpand(carId)
                .toUri();
    }
}
