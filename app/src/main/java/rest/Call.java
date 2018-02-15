package rest;

import android.content.Context;

import customs.ProgressLoading;
import model.WeatherResponse;
import retrofit2.Callback;
import retrofit2.Response;


public class Call {

    private ProgressLoading loading;
    private retrofit2.Call<WeatherResponse> call;
    private Delegate delegate;
    private String city;

    public Call(Context context, String city,Delegate delegate) {
        this.delegate       = delegate;
        this.city           = city;
        this.loading        = new ProgressLoading(context);
    }

    public void execute() {
        loading.onShow();
        CallInterface weatherCallInterface = Api.getClient().create(CallInterface.class);
        call = weatherCallInterface.getWeatherDays(city, Config.DAYS, Config.UNIT_TYPE, Config.APP_KEY);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(retrofit2.Call<WeatherResponse> call, Response<WeatherResponse> response) {
                int statusCode = response.code();
                if(statusCode == Config.RESP_OK) {
                    delegate.onSuccess(response.body());
                } else {
                    delegate.onFailure("On Failure - " + statusCode);
                }
                loading.dismiss();
            }
            @Override
            public void onFailure(retrofit2.Call<WeatherResponse> call, Throwable t) {
                delegate.onFailure(t.getMessage());
                loading.dismiss();
            }
        });
    }

    public interface Delegate {
        void onSuccess(WeatherResponse weatherResponse);
        void onFailure(Object t);
    }

}
