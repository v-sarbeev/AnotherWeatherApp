package ru.pixnstix.anotherweatherapp.data.networking;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.pixnstix.anotherweatherapp.data.networking.currentresponse.CurrentWeather;

/**
 * Created by me on 13.01.17.
 */

public interface IOpenWeatherAPI {

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String APPID = "31e7d02ef34fef6aa4b32a5352d66ccf";

    /**
     * Get current weather report from <a href="http://openweathermap.org/">OpenWeatherMap</a>
     * @param cityName  city name chosen or entered by user
     * @param appId     appId from {@link #APPID}
     * @param units     string representation from {@link Units}
     * @param lang      two characters country code from device locale
     * @return          reactive {@link Observable}
     */
    @GET("weather/?q={city_name}&appid={appid}&units={units}&lang={lang}")
    Observable<CurrentWeather> getCurrentWeather(
            @Path("city_name") String cityName,
            @Path("appid") String appId,
            @Path("units") String units,
            @Path("lang") String lang
    );

    enum Units {
        METRIC, IMPERIAL
    }
}
