package com.doctorgorgoner.forecaster.domain.network;

import com.doctorgorgoner.forecaster.domain.model.Forecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Doctor Gorgoner on 24.01.2018.
 */

public final class ApixuParser {

    List<Forecast> parseForecasts(String responseString) {
        try {
            JSONObject responseJson = new JSONObject(responseString);
            JSONArray dataJson = responseJson
                    .getJSONObject("forecast")
                    .getJSONArray("forecastday");

            List<Forecast> forecasts = new ArrayList<>();

            for (int i = 0; i < dataJson.length(); i++) {
                JSONObject itemJson = dataJson.getJSONObject(i);
                JSONObject forecastJson = itemJson.getJSONObject("day");

                forecasts.add(
                        new Forecast(
                                createDateStringFromUnixTimestamp(itemJson.getLong("date_epoch")),
                                forecastJson.getString("avgtemp_c") + "°C"
                        )
                );
            }

            return forecasts;

        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private String createDateStringFromUnixTimestamp(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp * 1000);

        DateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM", Locale.ROOT);
        return dateFormat.format(calendar.getTime());
    }
}
