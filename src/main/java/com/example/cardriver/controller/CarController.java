package com.example.cardriver.controller;

import com.example.cardriver.dto.CarCreateUpdateOperationDto;
import com.example.cardriver.dto.CarDto;
import com.example.cardriver.entity.CarEntity;
import com.example.cardriver.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @GetMapping("/all")
    public List<CarDto> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable("id") UUID id) {
        return carService.getCarById(id);
    }

    @PostMapping("/create")
    public CarDto createCar(@RequestBody CarDto carDto) {
        return carService.createCar(carDto);
    }

    @PutMapping("/update/{id}")
    public CarDto updateCar(@PathVariable("id") UUID id, @RequestBody CarDto carDto) {
        return carService.updateCar(id,carDto);
    }
}