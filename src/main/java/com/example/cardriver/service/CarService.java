package com.example.cardriver.service;

import com.example.cardriver.Repository.CarRepository;
import com.example.cardriver.dto.CarCreateUpdateOperationDto;
import com.example.cardriver.dto.CarDto;
import com.example.cardriver.entity.CarEntity;
import com.example.cardriver.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository repository;
    private final CarMapper mapper;

    public List<CarDto> getAllCars() {
        return mapper.toDtoList(repository.findAll());
    }

    public CarDto getCarById(UUID id) {
        return mapper.toDto(getCarEntityById(id));
    }

    public CarEntity createCar(CarDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    //mapper??
    public CarEntity updateCar(UUID id, CarDto dto) {
        CarEntity car = getCarEntityById(id);
        car.setNumber(dto.getNumber());
        car.setModel(dto.getModel());
        car.setColor(dto.getColor());
        car.setYear(dto.getYear());
        car.setCategory(dto.getCategory());
        return repository.save(car);
    }

    public CarEntity getCarEntityById(UUID id) {
        Optional<CarEntity> optionalDriver = repository.findById(id);
        if (optionalDriver.isEmpty()) {
            log.error("getDriverById.out - car with ID {} not found", id);
            //throw new DriverNotFoundException(String.format("car with id %s not found", id)); //почему закомменчено?
        }
        return optionalDriver.get();
    }
}
