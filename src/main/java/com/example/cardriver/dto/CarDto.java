package com.example.cardriver.dto;

import com.example.cardriver.entity.CarEntity;
import com.example.cardriver.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {

    private String model;
    private String number;
    private String color;
    private String year;
    private Category category;
}
