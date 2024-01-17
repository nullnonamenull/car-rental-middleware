package com.poleszak.carmanagementservice.service.tools.mapper;

import com.poleszak.carmanagementservice.model.Car;
import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.model.dto.CarDTO;
import com.poleszak.carmanagementservice.model.dto.CarGroupDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {CarMapper.class})
public interface CarGroupMapper {

    CarGroupDTO carGroupToCarGroupDTO(CarGroup carGroup);

    List<CarDTO> carsToCarDTOs(List<Car> cars);
}


