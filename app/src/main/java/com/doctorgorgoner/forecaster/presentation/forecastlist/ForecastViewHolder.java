package com.doctorgorgoner.forecaster.presentation.forecastlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.doctorgorgoner.forecaster.R;
import com.doctorgorgoner.forecaster.domain.model.Forecast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Doctor Gorgoner on 23.01.2018.
 */

public final class ForecastViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.date_text_view)
    TextView dateTextView;
    @BindView(R.id.temperature_text_view)
    TextView temperatureTextView;

    public ForecastViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    void bind(Forecast forecast) {
        dateTextView.setText(forecast.getDate());
        temperatureTextView.setText(forecast.getTemperature());
    }
}
