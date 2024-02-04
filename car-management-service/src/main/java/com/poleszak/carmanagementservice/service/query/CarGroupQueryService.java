package com.poleszak.carmanagementservice.service.query;

import com.poleszak.carmanagementservice.common.exception.CustomServiceException;
import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.model.dto.CarGroupDTO;
import com.poleszak.carmanagementservice.repository.CarGroupRepository;
import com.poleszak.carmanagementservice.service.tools.mapper.CarGroupMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.poleszak.carmanagementservice.common.exception.ErrorCode.CAR_GROUP_NOT_FOUND;

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

    public CarGroupDTO getCarGroupDTOById(Long carGroupId) {
        CarGroup carGroup = carGroupRepository.findById(carGroupId)
                .orElseThrow(() -> new CustomServiceException(CAR_GROUP_NOT_FOUND));

        return carGroupMapper.carGroupToCarGroupDTO(carGroup);
    }
}
