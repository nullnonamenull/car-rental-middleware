package com.poleszak.carmanagementservice.service.query;

import com.poleszak.carmanagementservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarQueryService {

    private final CarRepository carRepository;
}
