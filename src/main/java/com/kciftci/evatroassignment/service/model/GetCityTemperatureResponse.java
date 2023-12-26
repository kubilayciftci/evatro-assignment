package com.kciftci.evatroassignment.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public final class GetCityTemperatureResponse {

    private String name;
    private String temperature;
    private String unit;
}
