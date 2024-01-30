package com.poleszak.carmanagementservice.service.tools.mapper;

import com.poleszak.carmanagementservice.controller.command.request.CarCreationRequest;
import com.poleszak.carmanagementservice.model.Car;
import com.poleszak.carmanagementservice.model.dto.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(target = "name", source = "name")
    Car carCreationRequestToCar(CarCreationRequest carCreationRequest);

    @Mapping(target = "name", source = "name")
    CarDTO carToCarDTO(Car car);
}
