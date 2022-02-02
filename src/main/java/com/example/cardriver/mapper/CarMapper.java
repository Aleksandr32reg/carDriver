package com.example.cardriver.mapper;

import com.example.cardriver.dto.CarDto;
import com.example.cardriver.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CarMapper {
    CarDto toDto(CarEntity carEntity);
    CarEntity toEntity(CarDto carDto);
    List<CarDto> toDtoList(List<CarEntity> carEntities);
    CarEntity updateFromDto(CarDto source, @MappingTarget CarEntity target);
}
