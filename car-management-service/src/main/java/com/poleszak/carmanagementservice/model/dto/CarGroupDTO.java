package com.poleszak.carmanagementservice.model.dto;

import com.poleszak.carmanagementservice.model.enumerated.CarGroupVisibilityStatus;

import java.util.List;

public record CarGroupDTO(Long id,
                          String name,
                          List<CarDTO> carDTOs,
                          CarGroupVisibilityStatus carGroupVisibilityStatus) {
}
