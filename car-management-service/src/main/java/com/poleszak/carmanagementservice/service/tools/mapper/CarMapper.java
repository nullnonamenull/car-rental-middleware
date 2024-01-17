package com.poleszak.carmanagementservice.service.tools.mapper;

import com.poleszak.carmanagementservice.model.Car;
import com.poleszak.carmanagementservice.model.dto.CarDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDTO carToCarDTO(Car car);
}
