package com.poleszak.carmanagementservice.model;

import com.poleszak.carmanagementservice.model.enumerated.CarGroupVisibilityStatus;
import com.poleszak.carmanagementservice.model.enumerated.FuelType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Builder
@Entity
@Table(name = "car_group")
@NoArgsConstructor
@AllArgsConstructor
public class CarGroup {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "car_group_seq_gen")
    @SequenceGenerator(name = "car_group_seq_gen", sequenceName = "car_group_sequence", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "carGroup", cascade = ALL, fetch = EAGER)
    private List<Car> cars = new ArrayList<>();

    private Integer seatsNumber;

    private Integer doorsNumber;

    @Enumerated(STRING)
    private FuelType fuelType;

    @Enumerated(STRING)
    private CarGroupVisibilityStatus visibilityStatus;
}