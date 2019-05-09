package com.example.appproject;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.provider.DocumentsContract;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.appproject.Adapter.FoodAdapter;
import com.example.appproject.Models.DialogBox;
import com.example.appproject.Models.FoodDto.Rootobject;
import com.example.appproject.Models.Nitrition;
import com.example.appproject.Services.ServiceApi;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogBox.DialogListener {

    private Button BtnMainAddUser;
    private Button BtnMainFind;
    private EditText EditFodevare;
    private Button BtnMainAddList;
    private ListView FoodList;
    private Button BtnMainDetailStatus;
    private Button BtnMainStatus;
    private EditText EditMainName;
    private EditText EditMainHeight;
    private EditText EditMainWeight;
    ServiceApi serviceApi;
    boolean mBound = false;
    Rootobject foods;
    private FoodAdapter adapter;
    private ArrayList<Rootobject> nitritionArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnMainAddUser = (Button) findViewById(R.id.BtnMainAddUser);
        foods = new Rootobject();
        BtnMainFind = (Button) findViewById(R.id.BtnMainFind);
        EditMainName = (EditText)findViewById(R.id.EditMainName);
        EditMainHeight = (EditText)findViewById(R.id.EditMainHeight);
        EditFodevare = (EditText) findViewById(R.id.EditFodevare);
        BtnMainAddList = (Button) findViewById(R.id.BtnMainAddList);
        FoodList = (ListView) findViewById(R.id.List);
        BtnMainDetailStatus = (Button) findViewById(R.id.BtnMainDetailStatus);
        BtnMainStatus = (Button) findViewById(R.id.BtnMainStatus);
        EditMainWeight = (EditText)findViewById(R.id.EditMainWeight);

        BtnMainAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        BtnMainAddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fodevaretxt = EditFodevare.getText().toString();
                //check for correct
                serviceApi.searchFood(fodevaretxt);
            }
        });

        BtnMainDetailStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                godetail();
            }
        });

        BtnMainStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gostatus();
            }
        });

        LocalBroadcastManager.getInstance(this).registerReceiver(listener, new IntentFilter(("update-ui")));

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

    public void openDialog() {
        //reference: https://www.youtube.com/watch?v=ARezg1D9Zd0
        DialogBox dialogBox = new DialogBox();
        dialogBox.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void applyTexts(String name, String height, String weight) {
        EditMainName.setText(name);
        EditMainHeight.setText(height);
        EditMainWeight.setText(weight);

    }


    public void godetail() {
        Intent intent = new Intent(this, DetailStatusActivity.class);
        startActivity(intent);
    }

    public void gostatus() {
        Intent intent = new Intent(this, StatusActivity.class);
        startActivity(intent);
    }

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            ServiceApi.LocalBinder binder = (ServiceApi.LocalBinder) service;
            serviceApi = binder.getService();
            mBound = true;
            Log.d("MinService", "onServiceConnected: ");
            updateUI();

        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    public void updateUI()
    {
        nitritionArrayList = serviceApi.getfood();
        adapter = new FoodAdapter(this, nitritionArrayList );
        FoodList.setAdapter(adapter);

    }

    private BroadcastReceiver listener = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateUI();
        }
    };

}



