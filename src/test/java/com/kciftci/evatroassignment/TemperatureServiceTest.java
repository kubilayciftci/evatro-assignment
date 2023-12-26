package com.kciftci.evatroassignment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.kciftci.evatroassignment.model.CityTemperature;
import com.kciftci.evatroassignment.model.common.APIResponse;
import com.kciftci.evatroassignment.model.common.HttpStatus;
import com.kciftci.evatroassignment.model.common.TemperatureUnit;
import com.kciftci.evatroassignment.repository.CityTemperatureRepository;
import com.kciftci.evatroassignment.service.CityTemperatureService;
import com.kciftci.evatroassignment.service.model.GetCityTemperatureResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class TemperatureServiceTest {

    @Mock
    private CityTemperatureRepository temperatureRepository; // Assuming you have a repository

    @InjectMocks
    private CityTemperatureService temperatureService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTemperature_cityExists_returnsCityTemperature() {
        // Arrange
        String cityName = "Istanbul";
        String temperature = "8";
        Optional<CityTemperature> expectedTemperature = Optional.of(new CityTemperature(cityName, temperature, TemperatureUnit.CELCIUS));
        when(temperatureRepository.findCityTemperatureByName(cityName)).thenReturn(expectedTemperature);

        // Act
        APIResponse<GetCityTemperatureResponse> result = temperatureService.getCityTemperature(cityName);

        // Assert
        verify(temperatureRepository).findCityTemperatureByName(cityName);
        assertNotNull(result);
        assertEquals(expectedTemperature.get().getTemperature(), result.getResponse().getTemperature());
        assertEquals(expectedTemperature.get().getName(), result.getResponse().getName());
        assertEquals(expectedTemperature.get().getUnit().getName(), result.getResponse().getUnit());
        assertEquals(HttpStatus.SUCCESS, result.getStatus());
    }

    @Test
    void getTemperature_cityDoesNotExist_returnsNull() {
        // Arrange
        String cityName = "UnknownCity";
        when(temperatureRepository.findCityTemperatureByName(cityName)).thenReturn(Optional.empty());

        // Act
        APIResponse<GetCityTemperatureResponse> result = temperatureService.getCityTemperature(cityName);

        // Assert
        verify(temperatureRepository).findCityTemperatureByName(cityName);
        assertNull(result.getResponse());
        assertEquals(HttpStatus.FAILURE, result.getStatus());
    }
}

