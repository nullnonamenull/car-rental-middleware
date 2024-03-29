package com.poleszak.carmanagementservice.controller.query;

import com.poleszak.carmanagementservice.model.dto.CarGroupDTO;
import com.poleszak.carmanagementservice.service.query.CarGroupQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/query/car-group")
@RequiredArgsConstructor
public class CarGroupQueryController {

    private final CarGroupQueryService carGroupQueryService;

    @GetMapping
    public ResponseEntity<List<CarGroupDTO>> getAllCarGroupDTOs() {

        return ResponseEntity.ok().body(carGroupQueryService.getListOfAllCarGroupDTOs());
    }

    @GetMapping("/{carGroupId}")
    public ResponseEntity<CarGroupDTO> getCarGroupDTOById(@PathVariable("carGroupId") Long carGroupId) {

        return ResponseEntity.ok().body(carGroupQueryService.getCarGroupDTOById(carGroupId));
    }
}
