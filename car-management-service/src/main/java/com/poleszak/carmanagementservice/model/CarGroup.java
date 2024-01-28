package com.poleszak.carmanagementservice.model;

import com.poleszak.carmanagementservice.model.enumerated.CarGroupVisibilityStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "carGroup", cascade = CascadeType.ALL)
    private Set<Car> cars = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private CarGroupVisibilityStatus visibilityStatus;
}
