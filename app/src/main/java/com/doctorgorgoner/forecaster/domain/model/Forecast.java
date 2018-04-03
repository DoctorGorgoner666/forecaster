package com.doctorgorgoner.forecaster.domain.model;

/**
 * Created by Doctor Gorgoner on 23.01.2018.
 */

public final class Forecast {
    public final String date;
    public final String temperature;

    public Forecast(String date, String temperature) {
        this.date = date;
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public String getTemperature() {
        return temperature;
    }
}
