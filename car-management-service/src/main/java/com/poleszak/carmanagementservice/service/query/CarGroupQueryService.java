package com.poleszak.carmanagementservice.service.query;

import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.model.dto.CarGroupDTO;
import com.poleszak.carmanagementservice.repository.CarGroupRepository;
import com.poleszak.carmanagementservice.service.tools.mapper.CarGroupMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CarGroupQueryService {

    private final CarGroupRepository carGroupRepository;
    private final CarGroupMapper carGroupMapper;

    public List<CarGroupDTO> getListOfAllCarGroupDTOs() {
        List<CarGroup> carGroup = carGroupRepository.findAll();

        return carGroup.stream()
                .map(carGroupMapper::carGroupToCarGroupDTO)
                .toList();
    }
}
