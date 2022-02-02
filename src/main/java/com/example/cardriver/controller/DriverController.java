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
@RequestMapping("/driver")
public class DriverController {
    private final DriverService driverService;

    @GetMapping("/all")
    public List<DriverDto> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public DriverDto getDriverById(@PathVariable("id") UUID id) {
        return driverService.getDriverById(id);
    }

    @GetMapping("/license/{license}")
    public DriverDto getDriverByLicense(@PathVariable("license") String license) {
        return driverService.getDriverByLicense(license);
    }

    @PostMapping("/create")
    public DriverDto createDriver(@RequestBody DriverDto dto) {
        return driverService.createDriver(dto);
    }

    @PutMapping("/update/{id}")
    public DriverDto updateDriver(@PathVariable("id") UUID id, @RequestBody DriverDto dto) {
        return driverService.updateDriver(id, dto);
    }
}
