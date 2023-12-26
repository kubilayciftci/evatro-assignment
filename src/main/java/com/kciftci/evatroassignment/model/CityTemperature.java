package com.kciftci.evatroassignment.model;


import com.kciftci.evatroassignment.model.common.TemperatureUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city_temperature")
public class CityTemperature {

    @Id
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "unit")
    private TemperatureUnit unit;
}
