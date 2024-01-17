package com.poleszak.carmanagementservice.model;

import com.poleszak.carmanagementservice.model.enumerated.CarGroupVisibilityStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarGroup {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carGroup", fetch = FetchType.EAGER)
    private List<Car> cars;
    @Enumerated(EnumType.STRING)
    private CarGroupVisibilityStatus visibilityStatus;
}
