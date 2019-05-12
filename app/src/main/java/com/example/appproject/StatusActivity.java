package com.example.appproject;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.appproject.Models.Calculater.Calculater;
import com.example.appproject.Models.FoodDto.Rootobject;
import com.example.appproject.Models.VitaminValues;
import com.example.appproject.Services.ServiceApi;

import java.util.ArrayList;

public class StatusActivity extends AppCompatActivity {

    ServiceApi serviceApi;
    boolean mBound = false;
    private TextView Txt1;
    private ArrayList<Rootobject> nitritionArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Txt1 = (TextView)findViewById(R.id.Txt1);

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Bind to LocalService
        Intent intent = new Intent(this, ServiceApi.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        mBound = false;
    }


    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            ServiceApi.LocalBinder binder = (ServiceApi.LocalBinder) service;
            serviceApi = binder.getService();
            mBound = true;
            nitritionArrayList = serviceApi.getfood();
            Log.d("MinServiceStatus", "onServiceConnected: ");
            Calculater calculater = new Calculater();
            if(calculater.IsEnoughIron(nitritionArrayList)) {
                Txt1.setText("Du har fået nok jern");
            }
            else {
                Txt1.setText("Du har ikke fået nok jern");
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    // tODo when bound
    //   c = new Calculator(service.getFoods())
    //   c.calculateNutriion()
}
