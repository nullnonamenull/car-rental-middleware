package com.poleszak.carmanagementservice.service.command;

import com.poleszak.carmanagementservice.controller.command.request.CarCreationRequest;
import com.poleszak.carmanagementservice.controller.command.request.CarGroupCreationRequest;
import com.poleszak.carmanagementservice.model.Car;
import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.repository.CarGroupRepository;
import com.poleszak.carmanagementservice.repository.CarRepository;
import com.poleszak.carmanagementservice.service.tools.mapper.CarMapper;
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
    public URI createCarForCarGroup(CarCreationRequest carCreationRequest, Long carGroupId) {
        log.info("Received request to create car with name: {}", carCreationRequest.name());

        Car car = carMapper.carCreationRequestToCar(carCreationRequest);
        car.setCarGroup(carGroupRepository.findById(carGroupId).get());

        Car savedCar = carRepository.save(car);
        URI createdCarUri = generateCarGroupUri(savedCar.getId());
        log.info("New car saved with URI: {}", createdCarUri);

        return createdCarUri;
    }


    private URI generateCarGroupUri(Long carGroupId) {
        //TODO: define path in resources
        return UriComponentsBuilder.fromPath("/car-groups/{id}")
                .buildAndExpand(carGroupId)
                .toUri();
    }
}
