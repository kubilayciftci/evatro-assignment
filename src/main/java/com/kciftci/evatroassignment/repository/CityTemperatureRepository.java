package com.kciftci.evatroassignment.repository;

import com.kciftci.evatroassignment.model.CityTemperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityTemperatureRepository extends JpaRepository<CityTemperature, String> {
    Optional<CityTemperature> findCityTemperatureByName(String name);
}
