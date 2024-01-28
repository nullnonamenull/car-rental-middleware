package com.poleszak.carmanagementservice.controller.query;

import com.poleszak.carmanagementservice.service.query.CarQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/car/query")
@RequiredArgsConstructor
public class CarQueryController {

    private final CarQueryService carQueryService;
}
