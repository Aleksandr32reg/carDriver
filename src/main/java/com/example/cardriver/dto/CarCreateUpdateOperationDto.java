package com.example.cardriver.dto;

import com.example.cardriver.entity.CarEntity;
import com.example.cardriver.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarCreateUpdateOperationDto {

    @Pattern(regexp = "^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}$", message = "" +
            "Должно соответветстовать формату гос. знака РФ. А123БВ32")
    @NotBlank
    private String number;
    @NotBlank
    private String model;
    @NotBlank
    private String color;
    @NotNull
    private String year;
    @NotNull
    private Category category;
}
