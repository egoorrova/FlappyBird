package com.example.flappybird;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class APIRouter {
    private final String API_KEY = "7e70330e80bb48ccab3192529262602";

    public interface WeatherCallback {
        void onSuccess(String temperature);
        void onError(String error);
    }

    public void getResult(String city, Context context, WeatherCallback callback) {
        String url = "http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + city + "&aqi=no";

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            String temperature = obj.getJSONObject("current").getString("temp_c");
                            if (callback != null) {
                                callback.onSuccess(temperature);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("WeatherErr", "Error " + error.toString());
                    }
                }
        );

        queue.add(stringRequest);
    }
}