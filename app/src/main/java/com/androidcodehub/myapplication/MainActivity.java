package com.androidcodehub.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.androidcodehub.myapplication.databinding.ActivityMainBinding;


import adapter.WeatherAdapter;
import model.WeatherResponse;
import rest.Call;

public class MainActivity extends AppCompatActivity {

    private String CITY = "Delhi";
    private ActivityMainBinding binding;
    private Call actionCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.weatherRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        actionCall = new Call(this, CITY, new Call.Delegate() {
            @Override
            public void onSuccess(WeatherResponse weatherResponse) {
                binding.weatherRecyclerView.setAdapter(new WeatherAdapter(weatherResponse.listDays));
            }
            @Override
            public void onFailure(Object t) {

                Toast.makeText(getApplicationContext(), "Error = "+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
        actionCall.execute();
    }


    }

