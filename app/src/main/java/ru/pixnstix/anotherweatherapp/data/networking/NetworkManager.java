package ru.pixnstix.anotherweatherapp.data.networking;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import ru.pixnstix.anotherweatherapp.data.networking.currentresponse.CurrentWeather;
import ru.pixnstix.anotherweatherapp.data.networking.fivedayforecast.Weather;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

public class NetworkManager {

    public static final String TAG = "myNetworkManager";

    private static NetworkManager sInstance;

    private NetworkManager() {
    }

    public static NetworkManager getInstance() {
        synchronized (NetworkManager.class) {
            if (sInstance == null) {
                sInstance = new NetworkManager();
            }
            return sInstance;
        }
    }

    public static Observable<CurrentWeather> getCurrentWeather(String cityName, String appId,
                                                               String units, String lang) {
        OpenWeatherAPIService apiService = new OpenWeatherAPIService(IOpenWeatherAPI.BASE_URL);
        Observable<CurrentWeather> currentWeatherObservable = apiService.getCurrentWeather(
                cityName, appId, units, lang);
        currentWeatherObservable
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());

        return currentWeatherObservable;
    }

    public static Observable<CurrentWeather> getCurrentWeather(double latitude, double longitude,
                                                               String appId, String units,
                                                               String lang) {
        OpenWeatherAPIService apiService = new OpenWeatherAPIService(IOpenWeatherAPI.BASE_URL);
        Observable<CurrentWeather> currentWeatherObservable = apiService.getCurrentWeather(
                latitude, longitude, appId, units, lang);
        currentWeatherObservable
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());

        return currentWeatherObservable;
    }

    public static Observable<Weather> getFiveDaysForecast(String cityName, String appId,
                                                          String units, String lang) {
        OpenWeatherAPIService apiService = new OpenWeatherAPIService(IOpenWeatherAPI.BASE_URL);
        Observable<Weather> currentWeatherObservable = apiService.getFiveDaysForecast(
                cityName, appId, units, lang);
        currentWeatherObservable
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());

        return currentWeatherObservable;
    }

    public static Observable<Weather> getFiveDaysForecast(double latitude, double longitude,
                                                          String appId, String units,
                                                          String lang) {
        OpenWeatherAPIService apiService = new OpenWeatherAPIService(IOpenWeatherAPI.BASE_URL);
        Observable<Weather> currentWeatherObservable = apiService.getFiveDaysForecast(
                latitude, longitude, appId, units, lang);
        currentWeatherObservable
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());

        return currentWeatherObservable;
    }
}
