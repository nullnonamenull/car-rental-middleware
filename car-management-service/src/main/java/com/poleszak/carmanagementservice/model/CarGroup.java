package com.poleszak.carmanagementservice.model;

import com.poleszak.carmanagementservice.model.enumerated.CarGroupVisibilityStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CarGroup {

    private Long id;
    private String name;
    private List<Car> cars;
    private CarGroupVisibilityStatus visibilityStatus;
}
