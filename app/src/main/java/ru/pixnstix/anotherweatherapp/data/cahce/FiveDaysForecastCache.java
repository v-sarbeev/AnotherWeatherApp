package ru.pixnstix.anotherweatherapp.data.cahce;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

import io.reactivex.Observable;
import ru.pixnstix.anotherweatherapp.data.networking.currentresponse.CurrentWeather;
import ru.pixnstix.anotherweatherapp.data.networking.fivedayforecast.Weather;

/**
 * An interface representing {@link Weather} cache.
 */
public interface FiveDaysForecastCache {

    /**
     * Gets an {@link Observable} which will emit {@link Weather} entity.
     */
    Observable<Weather> get();

    /**
     * Replace cached entity with newer data.
     *
     * @param fiveDaysForecast  Element to put into cache.
     */
    void replace(Weather fiveDaysForecast);

    /**
     * Checks if cache is empty.
     *
     * @return  true if nothing is cached.
     */
    boolean isEmpty();

    /**
     * Checks if cache is expired.
     *
     * @return  true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Removes cached data.
     */
    void clear();
}
