package com.example.cardriver.entity;

import com.example.cardriver.enums.Category;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cars")
public class CarEntity extends BaseEntity {

    private String model;
    @Column(unique = true)
    private String number;
    private String color;
    private String year;
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "driver")
    private DriverEntity driver;

}
