package ru.pixnstix.anotherweatherapp.data.repository;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

import io.reactivex.Observable;
import ru.pixnstix.anotherweatherapp.data.networking.currentresponse.CurrentWeather;

/**
 * Main entry point for accessing current weather data
 */
public interface CurrentWeatherDataSource {

    Observable<CurrentWeather> getCurrentWeather(String cityName, String appId,
                                                 String units, String lang);

    Observable<CurrentWeather> getCurrentWeather(double latitude, double longitude,
                                                 String appId, String units,
                                                 String lang);

    void refreshCurrentWeather();
}
