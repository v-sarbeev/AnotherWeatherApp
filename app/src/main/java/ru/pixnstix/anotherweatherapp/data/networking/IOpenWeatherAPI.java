package ru.pixnstix.anotherweatherapp.data.networking;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.pixnstix.anotherweatherapp.data.networking.currentresponse.CurrentWeather;
import ru.pixnstix.anotherweatherapp.data.networking.fivedayforecast.Weather;

/**
 * Created by v-sarbeev on 13.01.17.
 */

public interface IOpenWeatherAPI {

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String APPID = "31e7d02ef34fef6aa4b32a5352d66ccf";

    /**
     * Gets current weather report from <a href="http://openweathermap.org/">OpenWeatherMap</a>
     * by city name
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

    /**
     * Gets current weather report from <a href="http://openweathermap.org/">OpenWeatherMap</a>
     * by city coordinates
     * @param latitude  latitude
     * @param longitude longitude (CO to the rescue! =))
     * @param appId     appId from {@link #APPID}
     * @param units     string representation from {@link Units}
     * @param lang      two characters country code from device locale
     * @return          reactive {@link Observable}
     */
    @GET("weather/?lat={lat}&lon={lon}&appid={appid}&units={units}&lang={lang}")
    Observable<CurrentWeather> getCurrentWeather(
            @Path("lat") double latitude,
            @Path("lon") double longitude,
            @Path("appid") String appId,
            @Path("units") String units,
            @Path("lang") String lang
    );

    /**
     * Gets 5-day weather forecast from <a href="http://openweathermap.org/">OpenWeatherMap</a>
     * by city name
     * @param cityName  city name chosen or entered by user
     * @param appId     appId from {@link #APPID}
     * @param units     string representation from {@link Units}
     * @param lang      two characters country code from device locale
     * @return          reactive {@link Observable}
     */
    @GET("forecast/?q={city_name}&appid={appid}&units={units}&lang={lang}")
    Observable<Weather> getFiveDaysForecast(
            @Path("city_name") String cityName,
            @Path("appid") String appId,
            @Path("units") String units,
            @Path("lang") String lang
    );

    /**
     * Gets 5-day weather forecast from <a href="http://openweathermap.org/">OpenWeatherMap</a>
     * by city coordinates
     * @param latitude  latitude
     * @param longitude longitude (CO to the rescue! =))
     * @param appId     appId from {@link #APPID}
     * @param units     string representation from {@link Units}
     * @param lang      two characters country code from device locale
     * @return          reactive {@link Observable}
     */
    @GET("forecast/?lat={lat}&lon={lon}&appid={appid}&units={units}&lang={lang}")
    Observable<Weather> getFiveDaysForecast(
            @Path("lat") double latitude,
            @Path("lon") double longitude,
            @Path("appid") String appId,
            @Path("units") String units,
            @Path("lang") String lang
    );

    /**
     * {@link #METRIC} should be default
     * TODO: switch units type in options when options and shared prefs become available
     */
    enum Units {
        METRIC, IMPERIAL
    }
}
