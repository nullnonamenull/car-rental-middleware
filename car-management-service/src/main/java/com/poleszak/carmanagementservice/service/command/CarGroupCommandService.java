package com.poleszak.carmanagementservice.service.command;

import com.poleszak.carmanagementservice.controller.command.request.CarGroupCreationRequest;
import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.repository.CarGroupRepository;
import com.poleszak.carmanagementservice.service.tools.mapper.CarGroupMapper;
import com.poleszak.carmanagementservice.service.tools.validator.CarGroupValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarGroupCommandService {


    private final CarGroupRepository carGroupRepository;
    private final CarGroupValidator carGroupValidator;
    private final CarGroupMapper carGroupMapper;


    public URI createCarGroup(CarGroupCreationRequest carGroupCreationRequest) {
        log.info("CarGroupCommandService::Starting creating car group process with name: {}", carGroupCreationRequest.name());

        carGroupValidator.validateCarGroupRequestCreation(carGroupCreationRequest);

        CarGroup carGroup = carGroupMapper.carGroupCreationRequestToCarGroup(carGroupCreationRequest);

        CarGroup savedCarGroup = carGroupRepository.save(carGroup);
        URI createdCarGroupUri = generateCarGroupUri(savedCarGroup.getId());
        log.info("CarGroupCommandService::New car group saved with URI: {}", createdCarGroupUri);

        return createdCarGroupUri;
    }


    private URI generateCarGroupUri(Long carGroupId) {
        //TODO: define path in resources
        return UriComponentsBuilder.fromPath("/car-groups/{id}")
                .buildAndExpand(carGroupId)
                .toUri();
    }
}