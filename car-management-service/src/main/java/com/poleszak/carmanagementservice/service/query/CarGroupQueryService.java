package com.poleszak.carmanagementservice.service.query;

import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.model.dto.CarGroupDTO;
import com.poleszak.carmanagementservice.repository.CarGroupRepository;
import com.poleszak.carmanagementservice.service.tools.mapper.CarGroupMapper;
import com.poleszak.carmanagementservice.service.tools.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarGroupQueryService {

    private final CarGroupRepository carGroupRepository;
    private final CarGroupMapper carGroupMapper;
    private final CarMapper carMapper;


    @Transactional(readOnly = true)
    public List<CarGroupDTO> getListOfAllCarGroupDTOs() {
        return carGroupRepository.findAll().stream()
                .map(carGroup -> new CarGroupDTO(
                        carGroup.getId(),
                        carGroup.getName(),
                        carGroup.getCars() != null
                                ? carGroup.getCars().stream()
                                .map(carMapper::carToCarDTO)
                                .collect(Collectors.toList())
                                : null))
                .toList();
    }

}