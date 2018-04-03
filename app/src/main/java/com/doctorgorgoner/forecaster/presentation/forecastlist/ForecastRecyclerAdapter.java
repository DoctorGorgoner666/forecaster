package com.doctorgorgoner.forecaster.presentation.forecastlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doctorgorgoner.forecaster.R;
import com.doctorgorgoner.forecaster.domain.model.Forecast;

import java.util.List;

/**
 * Created by Doctor Gorgoner on 23.01.2018.
 */

final class ForecastRecyclerAdapter extends RecyclerView.Adapter<ForecastViewHolder> {

    private final List<Forecast> forecasts;

    ForecastRecyclerAdapter(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.forecast_list_item,
                parent,
                false
        );

        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        holder.bind(forecasts.get(position));
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }
}
