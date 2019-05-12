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
import com.example.appproject.Models.Calculater.Calculater;
import com.example.appproject.Models.FoodDto.Nutrient;
import com.example.appproject.Models.FoodDto.Rootobject;
import com.example.appproject.Models.Nitrition;
import com.example.appproject.Models.VitaminValues;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class ServiceApi extends Service {

    ArrayList<Rootobject> foods;
    Rootobject searchresults;

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
        searchresults = new Rootobject();
        Log.d("MinNuService", "onServiceNuConnected: ");
        foods = new ArrayList<Rootobject>();
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

    public void searchFood(String dbno,final int unit) {
        final String url = "https://api.nal.usda.gov/ndb/V2/reports?ndbno=" + dbno + "&type=b&format=json&api_key=ZPGqFErNaYE90DRzRPJxyuF4fyt6gq15cbPdq1kT";

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new Gson();
                        // display response
                        Log.d("Response", response.toString());
                        searchresults = gson.fromJson(response.toString(),Rootobject.class);
                        searchresults.setUnit(unit);
                        foods.add(searchresults);
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

    public void forsjovtest() {
        for(Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            for(Nutrient n : allnutrients) {
                if(n.getGroup().equals("Vitamins")) {
                    Log.d("vits", n.getName() + " : " + n.getValue() + n.getUnit());
                }
            }
        }
    }



    public Calculater getNutrition()
    {
        Calculater c = new Calculater();
        return c;
    }





    public ArrayList<Rootobject> getfood()
    {
        return foods;
    }
}