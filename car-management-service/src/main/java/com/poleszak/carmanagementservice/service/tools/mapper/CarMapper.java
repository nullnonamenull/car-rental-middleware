package com.poleszak.carmanagementservice.service.tools.mapper;

import com.poleszak.carmanagementservice.controller.command.request.CarCreationRequest;
import com.poleszak.carmanagementservice.model.Car;
import com.poleszak.carmanagementservice.model.dto.CarDTO;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(componentModel = "spring", nullValueCheckStrategy = ALWAYS)
public interface CarMapper {

    Car carCreationRequestToCar(CarCreationRequest carCreationRequest);

    CarDTO carToCarDTO(Car car);

}
