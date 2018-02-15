package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class WeatherResponse {
    @SerializedName ("list")
    public List<Day> listDays;
}