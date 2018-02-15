package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Temperature implements Serializable {
    @SerializedName("morn")
    public float morn;
    @SerializedName("eve")
    public float eve;
    @SerializedName("night")
    public float night;
    @SerializedName("day")
    public float day;
}