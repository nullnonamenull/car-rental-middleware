package com.poleszak.carmanagementservice.service.tools.mapper;

import com.poleszak.carmanagementservice.controller.command.request.CarGroupCreationRequest;
import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.model.dto.CarGroupDTO;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(componentModel = "spring", uses = CarMapper.class, nullValueCheckStrategy = ALWAYS)
public interface CarGroupMapper {

    CarGroup carGroupCreationRequestToCarGroup(CarGroupCreationRequest carGroupCreationRequest);

    CarGroupDTO carGroupToCarGroupDTO(CarGroup carGroup);
}
