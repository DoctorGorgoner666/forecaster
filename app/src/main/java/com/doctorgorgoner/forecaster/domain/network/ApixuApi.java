package com.doctorgorgoner.forecaster.domain.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Doctor Gorgoner on 24.01.2018.
 */

interface ApixuApi {

    @GET("forecast.json")
    Call<ResponseBody> requestForecasts(
            @Query("key") String key,
            @Query("q") String q,
            @Query("days") String days
    );

    // http://api.apixu.com/v1/forecast.json?key=d003f050ad6d4c2caa3134527181501?q=55.751244,37.618423?days=10
}
