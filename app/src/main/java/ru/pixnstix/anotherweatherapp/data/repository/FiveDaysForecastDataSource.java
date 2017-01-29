package ru.pixnstix.anotherweatherapp.data.repository;

import io.reactivex.Observable;
import ru.pixnstix.anotherweatherapp.data.networking.fivedayforecast.Weather;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

/**
 * Main entry point for accessing five days weather forecast data
 */
public interface FiveDaysForecastDataSource {

    Observable<Weather> getCurrentWeather(String cityName, String appId,
                                          String units, String lang);

    Observable<Weather> getCurrentWeather(double latitude, double longitude,
                                                 String appId, String units,
                                                 String lang);

    void refreshFiveDaysForecast();
}
