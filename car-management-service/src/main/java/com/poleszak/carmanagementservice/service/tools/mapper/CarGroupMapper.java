package com.poleszak.carmanagementservice.service.tools.mapper;

import com.poleszak.carmanagementservice.controller.command.request.CarGroupCreationRequest;
import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.model.dto.CarGroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarGroupMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "visibilityStatus", source = "visibilityStatus")
    CarGroup carGroupCreationRequestToCarGroup(CarGroupCreationRequest carGroupCreationRequest);
    CarGroupDTO carGroupToCarGroupDTO(CarGroup carGroup);
}
