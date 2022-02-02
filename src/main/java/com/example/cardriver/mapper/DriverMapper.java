package com.example.cardriver.mapper;

import com.example.cardriver.dto.CarDto;
import com.example.cardriver.dto.DriverDto;
import com.example.cardriver.entity.CarEntity;
import com.example.cardriver.entity.DriverEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DriverMapper {
    DriverDto toDto(DriverEntity driverEntity);
    DriverEntity toEntity(DriverDto driverDto);
    List<DriverDto> toDtoList(List<DriverEntity> driverEntities);
    DriverEntity updateFromDto(DriverDto source, @MappingTarget DriverEntity target);
}
