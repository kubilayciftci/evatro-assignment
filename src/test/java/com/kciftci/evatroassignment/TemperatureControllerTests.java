package com.kciftci.evatroassignment;


import com.kciftci.evatroassignment.controller.CityTemperatureController;
import com.kciftci.evatroassignment.model.CityTemperature;
import com.kciftci.evatroassignment.model.common.APIResponse;
import com.kciftci.evatroassignment.model.common.HttpStatus;
import com.kciftci.evatroassignment.model.common.TemperatureUnit;
import com.kciftci.evatroassignment.service.CityTemperatureService;
import com.kciftci.evatroassignment.service.model.GetCityTemperatureResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TemperatureControllerTests {

    private MockMvc mockMvc;

    @Mock
    private CityTemperatureService temperatureService;

    @InjectMocks
    private CityTemperatureController temperatureController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(temperatureController).build();
    }

    @Test
    void getTemperatureByName_cityExists_returnsSuccessResponse() throws Exception {
        String cityName = "Istanbul";
        String temperature = "8";
        GetCityTemperatureResponse response = new GetCityTemperatureResponse(cityName, temperature, TemperatureUnit.CELCIUS.getName());
        when(temperatureService.getCityTemperature(cityName)).thenReturn(new APIResponse<>(HttpStatus.SUCCESS, response));

        mockMvc.perform(post("/temperature")
                        .contentType("application/json")
                        .content("{\"query\":\"Istanbul\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(HttpStatus.SUCCESS))
                .andExpect(jsonPath("$.response.name").value("Istanbul"));
    }

    @Test
    void getTemperatureByName_cityDoesNotExist_returnsFailureResponse() throws Exception {
        String cityName = "UnknownCity";
        when(temperatureService.getCityTemperature(cityName)).thenReturn(new APIResponse<>(HttpStatus.FAILURE, null));

        mockMvc.perform(post("/temperature")
                        .contentType("application/json")
                        .content("{\"query\":\"UnknownCity\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(HttpStatus.FAILURE));
    }
}
