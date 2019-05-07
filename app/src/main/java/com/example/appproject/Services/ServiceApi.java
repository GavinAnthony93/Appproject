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
import com.google.gson.Gson;

import org.json.JSONObject;

public class ServiceApi extends Service {

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
        Log.d("MinNuService", "onServiceNuConnected: ");

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
        final String url = "https://api.nal.usda.gov/ndb/search/?format=json&sort=n&max=25&api_key=ZPGqFErNaYE90DRzRPJxyuF4fyt6gq15cbPdq1kT&q=" + food;

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new Gson();
                        // display response
                        Log.d("Response", response.toString());

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

    public void FoodDetail(String fooddetail)
    {
        final String url = "https://api.nal.usda.gov/ndb/search/?format=json&sort=n&q&max=25&api_key=ZPGqFErNaYE90DRzRPJxyuF4fyt6gq15cbPdq1kT&y=" + fooddetail;

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new Gson();
                        // display response
                        Log.d("Response", response.toString());

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
