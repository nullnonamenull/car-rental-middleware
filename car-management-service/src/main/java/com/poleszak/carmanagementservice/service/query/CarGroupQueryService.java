package com.poleszak.carmanagementservice.service.query;

import com.poleszak.carmanagementservice.model.dto.CarGroupDTO;
import com.poleszak.carmanagementservice.repository.CarGroupRepository;
import com.poleszak.carmanagementservice.service.tools.mapper.CarGroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarGroupQueryService {
    private final CarGroupRepository carGroupRepository;
    private final CarGroupMapper carGroupMapper;

    public List<CarGroupDTO> getListOfAllCarGroupDTOs() {
        return carGroupRepository.findAll().stream()
                .map(carGroupMapper::carGroupToCarGroupDTO)
                .toList();
    }
}
