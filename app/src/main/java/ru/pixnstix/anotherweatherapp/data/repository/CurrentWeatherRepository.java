package ru.pixnstix.anotherweatherapp.data.repository;

import android.support.annotation.Nullable;

import io.reactivex.Observable;
import ru.pixnstix.anotherweatherapp.data.networking.currentresponse.CurrentWeather;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

public class CurrentWeatherRepository implements CurrentWeatherDataSource {

    public static final long EXPIRATION_TIME = 5 * 60 * 1000;

    @Nullable
    private static CurrentWeatherRepository sInstance = null;



    @Override
    public Observable<CurrentWeather> getCurrentWeather(String cityName, String appId,
                                                        String units, String lang) {
        return null;
    }

    @Override
    public Observable<CurrentWeather> getCurrentWeather(double latitude, double longitude,
                                                        String appId, String units, String lang) {
        return null;
    }

    @Override
    public void refreshCurrentWeather() {

    }
}
