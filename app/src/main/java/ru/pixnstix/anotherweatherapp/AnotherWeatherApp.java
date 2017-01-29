package ru.pixnstix.anotherweatherapp;

import android.app.Application;

import ru.pixnstix.anotherweatherapp.data.cahce.SharedPreferencesManager;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

public class AnotherWeatherApp extends Application {

    private SharedPreferencesManager mSharedPreferencesManager;

    @Override
    public void onCreate() {
        super.onCreate();

        mSharedPreferencesManager = SharedPreferencesManager.getInstance(this);
    }
}
