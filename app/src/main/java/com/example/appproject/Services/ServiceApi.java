package com.example.appproject.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.appproject.Models.Nitrition;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class ServiceApi extends Service {

    ArrayList<Nitrition> foods;
    Nitrition searchresults;


    private final IBinder binder = new LocalBinder();
    RequestQueue queue;

    public class LocalBinder extends Binder {
        public ServiceApi getService() {
            // Return this instance of LocalService so clients can call public methods
            return ServiceApi.this; // returner en instance af sig selv.
        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
        searchresults = new Nitrition();
        Log.d("MinNuService", "onServiceNuConnected: ");
        foods = new ArrayList<Nitrition>();
        queue = Volley.newRequestQueue(this);  // this = context
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return binder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void searchFood(String food) {
        final String url = "https://api.nal.usda.gov/ndb/search/?format=json&sort=r&max=25&api_key=ZPGqFErNaYE90DRzRPJxyuF4fyt6gq15cbPdq1kT&q=" + food;

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new Gson();
                        // display response
                        Log.d("Response", response.toString());
                        searchresults = gson.fromJson(response.toString(),Nitrition.class);
                        LocalBroadcastManager bm = LocalBroadcastManager.getInstance(getApplicationContext());
                        Intent intent = new Intent("update-ui");
                        bm.sendBroadcast(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );

        queue.add(getRequest);
    }

    public Nitrition getfood()
    {
        return searchresults;

    }

    public void FoodDetail(String fooddetail)
    {
        final String url = "https://api.nal.usda.gov/ndb/search/?format=json&sort=n&q&max=25&api_key=ZPGqFErNaYE90DRzRPJxyuF4fyt6gq15cbPdq1kT&y=" + fooddetail;
// https://api.nal.usda.gov/ndb/V2/reports?ndbno=18240&type=b&format=json&api_key=DEMO_KEY
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new Gson();
                        // display response
                        Log.d("Response", response.toString());
                        Nitrition nitrition = gson.fromJson(response.toString(),Nitrition.class);
                        LocalBroadcastManager bm = LocalBroadcastManager.getInstance(getApplicationContext());
                        Intent intent = new Intent("update-ui");
                        bm.sendBroadcast(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );

        queue.add(getRequest);

    }









}
