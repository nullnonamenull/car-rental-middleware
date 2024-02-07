package com.poleszak.carmanagementservice.service.query;

import com.poleszak.carmanagementservice.model.dto.CarDTO;
import com.poleszak.carmanagementservice.repository.CarRepository;
import com.poleszak.carmanagementservice.service.tools.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarQueryService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<CarDTO> getAllCarDTOs() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::carToCarDTO)
                .toList();
    }
}
