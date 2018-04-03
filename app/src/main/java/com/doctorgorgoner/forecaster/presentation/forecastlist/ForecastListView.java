package com.doctorgorgoner.forecaster.presentation.forecastlist;

import com.doctorgorgoner.forecaster.domain.model.Forecast;

import java.util.List;

/**
 * Created by Doctor Gorgoner on 23.01.2018.
 */

public interface ForecastListView {

    void display(List<Forecast> forecasts);

    void displayProgressBar();

    void hideProgressBar();
}
