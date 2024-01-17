package com.poleszak.carmanagementservice.model.dto;

import java.util.List;

public record CarGroupDTO(Long id,
                          String name,
                          List<CarDTO> carDTOs) {
}
