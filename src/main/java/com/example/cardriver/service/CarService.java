package com.example.cardriver.service;

import com.example.cardriver.Repository.CarRepository;
import com.example.cardriver.dto.CarCreateUpdateOperationDto;
import com.example.cardriver.dto.CarDto;
import com.example.cardriver.entity.CarEntity;
import com.example.cardriver.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public CarDto createCar(CarDto dto) {
        CarEntity createCar = repository.save(mapper.toEntity(dto));
        CarDto carDto = mapper.toDto(createCar);
        return carDto;
    }

    @Transactional
    public CarDto updateCar(UUID id, CarDto dto) {
        CarEntity car = getCarEntityById(id);
        CarEntity carUpdated = mapper.updateFromDto(dto, car);
        CarEntity carUpdatedPersisted = repository.save(carUpdated);
        return mapper.toDto(carUpdatedPersisted);
    }

    public CarEntity getCarEntityById(UUID id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("getCarById.out - dtp with ID {} not found", id);
            throw new RuntimeException(String.format("car with id %s not found", id));
        });
    }
}
