package com.poleszak.carmanagementservice.repository;

import com.poleszak.carmanagementservice.model.CarGroup;
import com.poleszak.carmanagementservice.model.enumerated.CarGroupVisibilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarGroupRepository extends JpaRepository<CarGroup, Long> {


    @Query("SELECT cg FROM CarGroup cg LEFT JOIN FETCH cg.cars")
    List<CarGroup> findAllWithCars();
}