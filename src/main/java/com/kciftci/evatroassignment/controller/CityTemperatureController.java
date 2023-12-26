package com.kciftci.evatroassignment.controller;


import com.kciftci.evatroassignment.model.common.APIResponse;
import com.kciftci.evatroassignment.service.CityTemperatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/temperature")
@RequiredArgsConstructor
public class CityTemperatureController {

    private final CityTemperatureService temperatureService;

    @PostMapping
    public ResponseEntity<APIResponse> getTemperatureByName(@RequestBody Map<String, String> body) {
        String cityName = body.get("query");
        return ResponseEntity.ok(temperatureService.getCityTemperature(cityName));
    }

    @GetMapping
    public ResponseEntity<APIResponse> getTemperatureByQueryParam(@RequestParam("q") String cityName) {
        return ResponseEntity.ok(temperatureService.getCityTemperature(cityName));
    }
}
