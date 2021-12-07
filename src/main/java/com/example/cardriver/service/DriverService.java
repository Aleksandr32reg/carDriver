package com.example.cardriver.service;

import com.example.cardriver.Repository.DriverRepository;
import com.example.cardriver.dto.DriverDto;
import com.example.cardriver.entity.DriverEntity;
import com.example.cardriver.mapper.DriverMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        Optional<DriverEntity> byLicenseNumber = repository.findByLicenseNumber(license);
        if(byLicenseNumber.isEmpty()){
            throw new EntityNotFoundException("driver is not found");
        }
        return mapper.toDto(byLicenseNumber.get());
    }
    
    public DriverEntity createDriver(DriverDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    //mapper
    public DriverEntity updateDriver(UUID id, DriverDto dto) {
        DriverEntity driver = getDriverEntityById(id);
        driver.setFirstName(dto.getFirstName());
        driver.setLastName(dto.getLastName());
        driver.setLicenseNumber(dto.getLicenseNumber());
        driver.setDrivingExp(dto.getDrivingExp());
        driver.setCars(dto.getCars());
        driver.setCategory(dto.getCategory());
        return repository.save(driver);
    }

    public DriverEntity getDriverEntityById(UUID id) {
        Optional<DriverEntity> optionalDriver = repository.findById(id);
        if (optionalDriver.isEmpty()) {
            log.error("getDriverById.out - Driver with ID {} not found", id);
            //throw new DriverNotFoundException(String.format("Driver with id %s not found", id)); //?
        }
        return optionalDriver.get();
    }
}
