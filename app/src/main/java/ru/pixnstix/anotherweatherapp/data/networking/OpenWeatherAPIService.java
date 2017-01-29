package ru.pixnstix.anotherweatherapp.data.networking;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.pixnstix.anotherweatherapp.data.networking.currentresponse.CurrentWeather;
import ru.pixnstix.anotherweatherapp.data.networking.fivedayforecast.Weather;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

public class OpenWeatherAPIService {

    public static final String TAG = "myOpenWeatherAPIService";

    private IOpenWeatherAPI mOpenWeatherAPI;
    private boolean mIsRequestingCurrentWeather;
    private boolean mIsRequestingFiveDaysForecast;

    public OpenWeatherAPIService(String baseUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();

        this.mOpenWeatherAPI = retrofit.create(IOpenWeatherAPI.class);
    }

    public boolean ismIsRequestingCurrentWeather() {
        return mIsRequestingCurrentWeather;
    }

    public boolean ismIsRequestingFiveDaysForecast() {
        return mIsRequestingFiveDaysForecast;
    }

    public Observable<CurrentWeather> getCurrentWeather(String cityName, String appId,
                                                        String units, String lang) {
        return mOpenWeatherAPI.getCurrentWeather(cityName, appId, units, lang)
                .doOnSubscribe(disposable -> mIsRequestingCurrentWeather = true)
                .doOnTerminate(() -> mIsRequestingCurrentWeather = false)
                .doOnError(this::handleWeatherRequestingError);
    }

    public Observable<CurrentWeather> getCurrentWeather(double latitude, double longitude,
                                                        String appId, String units, String lang) {
        return mOpenWeatherAPI.getCurrentWeather(latitude, longitude, appId, units, lang)
                .doOnSubscribe(disposable -> mIsRequestingCurrentWeather = true)
                .doOnTerminate(() -> mIsRequestingCurrentWeather = false)
                .doOnError(this::handleWeatherRequestingError);
    }

    public Observable<Weather> getFiveDaysForecast(String cityName, String appId,
                                                   String units, String lang) {
        return mOpenWeatherAPI.getFiveDaysForecast(cityName, appId, units, lang)
                .doOnSubscribe(disposable -> mIsRequestingFiveDaysForecast = true)
                .doOnTerminate(() -> mIsRequestingFiveDaysForecast = false)
                .doOnError(this::handleWeatherRequestingError);
    }

    public Observable<Weather> getFiveDaysForecast(double latitude, double longitude,
                                                        String appId, String units, String lang) {
        return mOpenWeatherAPI.getFiveDaysForecast(latitude, longitude, appId, units, lang)
                .doOnSubscribe(disposable -> mIsRequestingFiveDaysForecast = true)
                .doOnTerminate(() -> mIsRequestingFiveDaysForecast = false)
                .doOnError(this::handleWeatherRequestingError);
    }

    private void handleWeatherRequestingError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
