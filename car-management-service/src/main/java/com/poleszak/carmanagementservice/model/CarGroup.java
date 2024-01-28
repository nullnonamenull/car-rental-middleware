package com.poleszak.carmanagementservice.model;

import com.poleszak.carmanagementservice.model.enumerated.CarGroupVisibilityStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarGroup {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "car_group_seq_gen")
    @SequenceGenerator(name = "car_group_seq_gen", sequenceName = "car_group_sequence", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "carGroup", cascade = CascadeType.ALL)
    private Set<Car> cars = new HashSet<>();

    @Enumerated(STRING)
    private CarGroupVisibilityStatus visibilityStatus;
}
