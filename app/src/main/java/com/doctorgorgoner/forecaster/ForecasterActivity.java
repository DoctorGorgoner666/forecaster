package com.doctorgorgoner.forecaster;

import android.support.v4.app.Fragment;

import com.doctorgorgoner.forecaster.presentation.forecastlist.ForecastListFragment;

public final class ForecasterActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ForecastListFragment();
    }
}
