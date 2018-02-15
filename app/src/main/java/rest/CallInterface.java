package rest;

import model.WeatherResponse;
import retrofit2.*;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gulgulu on 14-02-2018.
 */

public interface CallInterface {

    @GET("daily?")
        //http://api.openweathermap.org/data/2.5/forecast/daily?q=Palermo,it&cnt=8&APPID=b241c825823611967aaaa82711951620
    retrofit2.Call<WeatherResponse> getWeatherDays(@Query("q") String city, @Query("cnt") String countDays, @Query("units") String unitType , @Query("APPID") String appID);
}

