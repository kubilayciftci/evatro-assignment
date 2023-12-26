package com.kciftci.evatroassignment.model.common;

import com.kciftci.evatroassignment.model.CityTemperature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class APIResponse<T> {

    private String status;
    private T response;
}
