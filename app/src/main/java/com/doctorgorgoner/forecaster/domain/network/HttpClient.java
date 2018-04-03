package com.doctorgorgoner.forecaster.domain.network;

import android.util.Log;

import com.doctorgorgoner.forecaster.domain.ForecastProvider;
import com.doctorgorgoner.forecaster.domain.model.Forecast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Doctor Gorgoner on 24.01.2018.
 */

public final class HttpClient implements ForecastProvider {

    private static final String BASE_URL = "http://api.apixu.com/v1/";
    private static final String API_KEY = "d003f050ad6d4c2caa3134527181501";
    private static final String POSITION = "55.751244,37.618423";
    private static final String TAG = "HttpClient";
    private static HttpClient instance;
    private final ApixuApi apixuApi;
    private ForecastProvider.Listener listener;

    private HttpClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
        apixuApi = retrofit.create(ApixuApi.class);
    }

    public static HttpClient getInstance() {
        if (instance == null) instance = new HttpClient();
        return instance;
    }

    @Override
    public void setForecastProviderListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void requestForecasts() {
        Call<ResponseBody> call = apixuApi.requestForecasts(API_KEY, POSITION, "10");
        final List<Forecast> forecasts = new ArrayList<>();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ResponseBody responseBody = response.body();

                    if (responseBody != null) {
                        forecasts.addAll(
                                new ApixuParser().parseForecasts(responseBody.string())
                        );

                        if (listener != null) listener.onForecastsReady(forecasts);
                    } else {
                        Log.d(TAG, "onResponse: NULL BODY");
                    }
                } catch (IOException e) {
                    Log.d(TAG, "onResponse: IOException");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}
