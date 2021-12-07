package com.example.cardriver.entity;


import com.example.cardriver.enums.Category;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "driver")
public class DriverEntity extends BaseEntity {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String licenseNumber;
    private Integer drivingExp;
    private Category category;


    @OneToMany // никаких каскадов лейзи, ничо не надо?
    private List<CarEntity> cars;
}
