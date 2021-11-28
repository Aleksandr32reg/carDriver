package com.example.cardriver.controller;

import com.example.cardriver.dto.DriverDto;
import com.example.cardriver.entity.DriverEntity;
import com.example.cardriver.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/controllerDrivers")
public class DriverController {
    private final DriverService driverService;

    @GetMapping("/drivers/all")
    public List<DriverDto> getAllDrivers() { return driverService.getAllDrivers(); }
    @GetMapping("/driver/{id}")
    public DriverDto getDriverById(@PathVariable("id") UUID id) { return driverService.getDriverById(id); }

    @PostMapping("/driver/create")
    public DriverEntity createDriver(@RequestBody DriverDto dto) { return driverService.createDriver(dto); }
    @PostMapping("/driver/update")
    public DriverEntity updateDriver(@RequestBody UUID id, @RequestBody DriverDto dto) { return driverService.updateDriver(id, dto); }
}
