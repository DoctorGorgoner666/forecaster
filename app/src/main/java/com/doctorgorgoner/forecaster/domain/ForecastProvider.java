package com.doctorgorgoner.forecaster.domain;

import com.doctorgorgoner.forecaster.domain.model.Forecast;

import java.util.List;

/**
 * Created by Doctor Gorgoner on 23.01.2018.
 */

public interface ForecastProvider {

    interface Listener {

        void onForecastsReady(List<Forecast> forecasts);
    }

    void setForecastProviderListener(Listener listener);

    void requestForecasts();
}
