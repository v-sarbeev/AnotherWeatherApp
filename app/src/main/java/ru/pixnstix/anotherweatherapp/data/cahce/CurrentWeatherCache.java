package ru.pixnstix.anotherweatherapp.data.cahce;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

import io.reactivex.Observable;
import ru.pixnstix.anotherweatherapp.data.networking.currentresponse.CurrentWeather;

/**
 * An interface representing {@link CurrentWeather} cache.
 */
public interface CurrentWeatherCache {

    /**
     * Gets an {@link Observable} which will emit {@link CurrentWeather} entity.
     */
    Observable<CurrentWeather> get();

    /**
     * Replace cached entity with newer data.
     *
     * @param currentWeatherEntity  Element to put into cache.
     */
    void replace(CurrentWeather currentWeatherEntity);

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
