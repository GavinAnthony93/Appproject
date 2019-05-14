package com.example.appproject.Services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
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
import com.example.appproject.R;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class ServiceApi extends Service {

    ArrayList<Rootobject> foods;
    Rootobject searchresults;
    private static final String CHANNEL_ID = "minChannel";
    private boolean isRunning;


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
        //reference: https://www.itsalif.info/content/android-volley-tutorial-http-get-post-put?fbclid=IwAR0gkLnaiig4RYBcmHNfFUdDRZACf2ZqAU-TIOnlIABARBa8mffKsKkPAwc
        foods = new ArrayList<Rootobject>();
        queue = Volley.newRequestQueue(this);  // this = context
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        isRunning = true;
        createNotificationChannel();
        startNotifier();

        return binder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void searchFood(String dbno, final int unit) {
        final String url = "https://api.nal.usda.gov/ndb/V2/reports?ndbno=" + dbno + "&type=b&format=json&api_key=ZPGqFErNaYE90DRzRPJxyuF4fyt6gq15cbPdq1kT";

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new Gson();
                        // display response
                        Log.d("Response", response.toString());
                        searchresults = gson.fromJson(response.toString(), Rootobject.class);
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
        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            for (Nutrient n : allnutrients) {
                if (n.getGroup().equals("Vitamins")) {
                    Log.d("vits", n.getName() + " : " + n.getValue() + n.getUnit());
                }
            }
        }
    }

    public Calculater getNutrition() {
        Calculater c = new Calculater();
        return c;
    }

    public ArrayList<Rootobject> getfood() {
        return foods;
    }

    //reference: https://www.androidauthority.com/how-to-create-android-notifications-707254/?fbclid=IwAR0yTSwMu33__aMCm3FcpdO9UNbxs4C8Gy3cKzm4H5k1oLuLIMj2uRnKjyk

    private void startNotifier() {
        new Notifier().execute();

    }

    class Notifier extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... uri) {
            while(isRunning) {
                Log.d("running", "isrunning");
                try {
                    if(foods.size() > 0) {
                        int randomIndex = (int) (Math.random() * foods.size());
                        NotificationCompat.Builder mBuilder =
                                new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                                        .setContentTitle("Oplysning om den valgte fødevare")
                                        .setContentText("Godt at du spiser: " + foods.get(randomIndex).getunit())
                                        .setSmallIcon(R.drawable.ic_launcher_background);
                        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        mNotificationManager.notify(001, mBuilder.build());
                        Thread.sleep(60000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "";
        }

        @Override
        protected void onPostExecute(String responseString) {
            Log.e("status", "");
            // On service completion you result will be posted back to the activity
            // mListener.loginFinished(responseString);
        }
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "minChannel";
            String description = "blabla";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}














