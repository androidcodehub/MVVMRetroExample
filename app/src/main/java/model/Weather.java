package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Weather implements Serializable {
    @SerializedName("main")
    public String main;
    @SerializedName("icon")
    public String icon;
}