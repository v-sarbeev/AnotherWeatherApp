package ru.pixnstix.anotherweatherapp.data.cahce;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import ru.pixnstix.anotherweatherapp.data.networking.IOpenWeatherAPI.Units;

/**
 * For simplification data is cached in shared preferences file.
 */
public class SharedPreferencesManager {

    private static final String SHARED_PREFERENCES_KEY = "ru.pixnstix.anotherweatherapp";
    private static final String CURRENT_WEATHER_KEY = "current_weather";
    private static final String CURRENT_WEATHER_UPDATE_TIME_KEY = "current_weather_UPDATE_TIME";
    private static final String FIVE_DAYS_FORECAST_KEY = "five_days_forecast";
    private static final String FIVE_DAYS_FORECAST_UPDATE_TIME_KEY = "five_days_forecast_UPDATE_TIME";
    private static final String MEASUREMENT_UNITS = "measurement_units";

    @Nullable
    private static SharedPreferencesManager sInstance = null;

    private SharedPreferences mSharedPreferences;

    /**
     * Singleton private constructor
     */
    private SharedPreferencesManager(Context context) {

        this.mSharedPreferences = context.getSharedPreferences(
                SHARED_PREFERENCES_KEY,
                Context.MODE_PRIVATE
        );

        String units = getMeasurementUnits();
        if (units.equals("")) {
            storeUnits(Units.METRIC.name());
        }
    }

    public static SharedPreferencesManager getInstance(Context context) {

        synchronized (SharedPreferencesManager.class) {
            if (sInstance == null) {
                sInstance = new SharedPreferencesManager(context);
            }

            return sInstance;
        }
    }

    /**
     * "Universal {@link String}-storing method
     * params are key-value pair respectively
     */
    private void storeStringInSharedPreferences(String key, String content) {

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, content);
        editor.apply();
    }

    /**
     * "Universal long-storing method
     * params are key-value pair respectively
     */
    private void storeLongInSharedPreferences(String key, long content) {

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putLong(key, content);
        editor.apply();
    }

    /**
     * "Universal {@link String}-getting method
     */
    private String getStringFromSharedPreferences(String key) {

        return mSharedPreferences.getString(key, "");
    }

    /**
     * "Universal long-getting method
     */
    private long getLongFromSharedPreferences(String key) {

        return mSharedPreferences.getLong(key, -1);
    }

    /**
     * "Universal {@link String}-deleting method
     */
    private void removeStringFromSharedPreferences(String key) {

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }


    public void storeCurrentWeather(String currentWeather) {
        storeStringInSharedPreferences(CURRENT_WEATHER_KEY, currentWeather);
    }

    public void storeCurrentWeatherUpdateTime(long updateTime) {
        storeLongInSharedPreferences(CURRENT_WEATHER_UPDATE_TIME_KEY, updateTime);
    }

    public String getCurrentWeather() {
        return getStringFromSharedPreferences(CURRENT_WEATHER_KEY);
    }

    public long getCurrentWeatherUpdateTime() {
        return getLongFromSharedPreferences(CURRENT_WEATHER_UPDATE_TIME_KEY);
    }

    public void removeCurrentWeather() {
        removeStringFromSharedPreferences(CURRENT_WEATHER_KEY);
    }

    public void storeFiveDaysForecast(String fiveDaysForecast) {
        storeStringInSharedPreferences(FIVE_DAYS_FORECAST_KEY, fiveDaysForecast);
    }

    public void storeFiveDaysForecastUpdateTime(long updateTime) {
        storeLongInSharedPreferences(FIVE_DAYS_FORECAST_UPDATE_TIME_KEY, updateTime);
    }

    public String getFiveDaysForecast() {
        return getStringFromSharedPreferences(FIVE_DAYS_FORECAST_KEY);
    }

    public long getFiveDaysForecastUpdateTime() {
        return getLongFromSharedPreferences(FIVE_DAYS_FORECAST_UPDATE_TIME_KEY);
    }

    public void removeFiveDaysForecast() {
        removeStringFromSharedPreferences(FIVE_DAYS_FORECAST_KEY);
    }

    /**
     * Measurement units cannot be removed.
     * Default value is {@link Units#METRIC}
     * @param units {@link Units}
     */
    public void storeUnits(String units) {
        storeStringInSharedPreferences(MEASUREMENT_UNITS, units);
    }

    public String getMeasurementUnits() {
        return getStringFromSharedPreferences(MEASUREMENT_UNITS);
    }
}
