package com.kciftci.evatroassignment.service;

import com.kciftci.evatroassignment.model.CityTemperature;
import com.kciftci.evatroassignment.model.common.APIResponse;
import com.kciftci.evatroassignment.model.common.HttpStatus;
import com.kciftci.evatroassignment.repository.CityTemperatureRepository;
import com.kciftci.evatroassignment.service.model.GetCityTemperatureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityTemperatureService {

    private final CityTemperatureRepository repository;

    public APIResponse<GetCityTemperatureResponse> getCityTemperature(String name) {
        return repository.findCityTemperatureByName(name)
                .map(temperature -> new GetCityTemperatureResponse(temperature.getName(), temperature.getTemperature(), temperature.getUnit().getName()))
                .map(response -> new APIResponse<>(HttpStatus.SUCCESS, response))
                .orElse(new APIResponse<>(HttpStatus.FAILURE, null));
    }

}
