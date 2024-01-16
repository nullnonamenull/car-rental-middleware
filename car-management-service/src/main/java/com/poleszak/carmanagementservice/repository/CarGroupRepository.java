package com.poleszak.carmanagementservice.repository;

import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.model.enumerated.CarGroupVisibilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarGroupRepository extends JpaRepository<CarGroup, Long> {

    Optional<CarGroup> findCarGroupByName(String carGroupName);

    List<CarGroup> findAllByVisibilityStatus(CarGroupVisibilityStatus carGroupVisibilityStatus);
}