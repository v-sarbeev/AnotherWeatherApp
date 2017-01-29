package ru.pixnstix.anotherweatherapp.data.cahce.serializer;

/**
 * Created by v-sarbeev on 29.01.2017.
 */

import com.google.gson.Gson;

/**
 * Json serializer/deserializer
 */

public class Serializer {

    private static Gson sGson = new Gson();

    /**
     * Serializes object to Json
     *
     * @param object object to serialize
     */
    public static String serialize(Object object, Class aClass) {
        return sGson.toJson(object, aClass);
    }

    /**
     * Deserializes Json-string to an object
     *
     * @param json json string to be deserialized
     */
    public static <T> T deserialize(String json, Class<T> tClass) {
        return sGson.fromJson(json, tClass);
    }
}
