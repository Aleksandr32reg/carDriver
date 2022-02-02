package com.example.cardriver.entity;


import com.example.cardriver.enums.Category;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "drivers")
public class DriverEntity extends BaseEntity {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String licenseNumber;
    private Integer drivingExp;
    private Category category;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
    @JoinColumn(name = "driver")
    private List<CarEntity> cars;
}
