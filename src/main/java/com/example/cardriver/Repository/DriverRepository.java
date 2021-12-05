package com.example.cardriver.Repository;

import com.example.cardriver.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, UUID> {
    
    Optional<DriverEntity> findByLicenseNumber(String license);
}
