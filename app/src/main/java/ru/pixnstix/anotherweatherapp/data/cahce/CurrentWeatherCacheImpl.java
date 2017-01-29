package ru.pixnstix.anotherweatherapp.data.cahce;

import io.reactivex.Observable;
import ru.pixnstix.anotherweatherapp.data.cahce.serializer.Serializer;
import ru.pixnstix.anotherweatherapp.data.exception.CacheIsNotValidException;
import ru.pixnstix.anotherweatherapp.data.networking.currentresponse.CurrentWeather;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

public class CurrentWeatherCacheImpl implements CurrentWeatherCache {

    private static final long EXPIRATION_TIME = 60 * 10 * 1000;

    private SharedPreferencesManager mSharedPreferencesManager;

    public CurrentWeatherCacheImpl(Serializer mSerializer, SharedPreferencesManager mSharedPreferencesManager) {

        if (mSharedPreferencesManager == null) {
            throw new IllegalArgumentException("Invalid null parameter");
        }

        this.mSharedPreferencesManager = mSharedPreferencesManager;
    }

    @Override
    public Observable<CurrentWeather> get() {
        return Observable.create(emitter -> {
            final String currentContent =
                    CurrentWeatherCacheImpl.this.mSharedPreferencesManager.getCurrentWeather();
            final CurrentWeather currentWeather =
                    Serializer.deserialize(currentContent, CurrentWeather.class);

            if (currentWeather != null) {
                emitter.onNext(currentWeather);
                emitter.onComplete();
            } else {
                emitter.onError(new CacheIsNotValidException());
            }
        });
    }

    @Override
    public void replace(CurrentWeather currentWeatherEntity) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void clear() {

    }
}
