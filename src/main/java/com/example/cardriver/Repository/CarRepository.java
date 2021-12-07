package com.example.cardriver.Repository;

import com.example.cardriver.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//@Repository?
public interface CarRepository extends JpaRepository<CarEntity, UUID> {
}
