package com.poleszak.carmanagementservice.repository;

import com.poleszak.carmanagementservice.model.CarGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarGroupRepository extends JpaRepository<CarGroup, Long> {

    Optional<CarGroup> findCarGroupByName(String name);

}