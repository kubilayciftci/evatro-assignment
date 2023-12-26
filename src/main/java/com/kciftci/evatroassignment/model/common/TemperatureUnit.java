package com.kciftci.evatroassignment.model.common;

public enum TemperatureUnit {
    CELCIUS("celcius"),
    FAHRENHEIT("fahrenheit");

    private final String name;

    TemperatureUnit(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
