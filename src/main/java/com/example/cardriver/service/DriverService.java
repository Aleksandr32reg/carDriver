package com.example.cardriver.service;

import com.example.cardriver.Repository.DriverRepository;
import com.example.cardriver.dto.CarDto;
import com.example.cardriver.dto.DriverDto;
import com.example.cardriver.entity.CarEntity;
import com.example.cardriver.entity.DriverEntity;
import com.example.cardriver.mapper.DriverMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository repository;
    private final DriverMapper mapper;

    public List<DriverDto> getAllDrivers() {
        return mapper.toDtoList(repository.findAll());
    }

    public DriverDto getDriverById(UUID id) {
        return mapper.toDto(getDriverEntityById(id));
    }

    public DriverDto getDriverByLicense(String license) {
        return mapper.toDto(getDriverEntityByLicense(license));
    }

    @Transactional
    public DriverDto createDriver(DriverDto dto) {
        DriverEntity createDriver = repository.save(mapper.toEntity(dto));
        DriverDto driverDto = mapper.toDto(createDriver);
        return driverDto;
    }

    @Transactional
    public DriverDto updateDriver(UUID id, DriverDto dto) {
        DriverEntity driver = getDriverEntityById(id);
        DriverEntity carUpdated = mapper.updateFromDto(dto, driver);
        DriverEntity carUpdatedPersisted = repository.save(carUpdated);
        return mapper.toDto(carUpdatedPersisted);
    }

    public DriverEntity getDriverEntityByLicense(String license) {
        return repository.findByLicenseNumber(license).orElseThrow(() -> {
            log.error("getDriverById.out - dtp with ID {} not found", license);
            throw new EntityNotFoundException(String.format("Driver with id %s not found", license));
        });
    }

    public DriverEntity getDriverEntityById(UUID id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("getDriverById.out - dtp with ID {} not found", id);
            throw new EntityNotFoundException(String.format("Driver with id %s not found", id));
        });
    }
}
