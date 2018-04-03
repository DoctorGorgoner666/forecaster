package com.doctorgorgoner.forecaster.presentation.forecastlist;

import com.doctorgorgoner.forecaster.domain.ForecastProvider;
import com.doctorgorgoner.forecaster.domain.model.Forecast;

import java.util.List;

/**
 * Created by Doctor Gorgoner on 24.01.2018.
 */

final class ForecastListPresenter implements ForecastProvider.Listener {

    private final ForecastListView view;
    private final ForecastProvider forecastProvider;

    ForecastListPresenter(ForecastListView view, ForecastProvider forecastProvider) {
        this.view = view;
        this.forecastProvider = forecastProvider;
    }

    void onViewDisplayed() {
        forecastProvider.setForecastProviderListener(this);
        forecastProvider.requestForecasts();
        view.displayProgressBar();
    }

    @Override
    public void onForecastsReady(List<Forecast> forecasts) {
        view.hideProgressBar();
        view.display(forecasts);
    }
}
