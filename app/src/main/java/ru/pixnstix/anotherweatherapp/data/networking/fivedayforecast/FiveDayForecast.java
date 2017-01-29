
package ru.pixnstix.anotherweatherapp.data.networking.fivedayforecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FiveDayForecast {

    @SerializedName("city")
    @Expose
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
