package com.example.appproject;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.appproject.Models.DialogBox;
import com.example.appproject.Services.ServiceApi;

public class MainActivity extends AppCompatActivity implements DialogBox.DialogListener {

private Button BtnMainAddUser;
private Button BtnMainFind;
private EditText EditFodevare;
private Button BtnMainAddList;
private ListView List;
private Button BtnMainDetailStatus;
private Button BtnMainStatus;
private EditText EditMainName;
private EditText EditMainHeight;
private ServiceApi serviceApi;
boolean mBound = false;
private ListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnMainAddUser = (Button)findViewById(R.id.BtnMainAddUser);
        BtnMainFind = (Button)findViewById(R.id.BtnMainFind);
        EditFodevare = (EditText) findViewById(R.id.EditFodevare);
        BtnMainAddList = (Button)findViewById(R.id.BtnMainAddList);
        List = (ListView)findViewById(R.id.List);
        BtnMainDetailStatus = (Button)findViewById(R.id.BtnMainDetailStatus);
        BtnMainStatus = (Button)findViewById(R.id.BtnMainStatus);

        BtnMainAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        BtnMainAddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
    public void openDialog()
    {
        //reference: https://www.youtube.com/watch?v=ARezg1D9Zd0
        DialogBox dialogBox =new DialogBox();
        dialogBox.show(getSupportFragmentManager(),"dialog");
    }

    @Override
    public void applyTexts(String name, String height) {
        EditMainName.setText(name);
        EditMainHeight.setText(height);

    }



    public void godetail()
    {
        Intent intent = new Intent(this,DetailStatusActivity.class);
        startActivity(intent);
    }

    public void gostatus()
    {
        Intent intent = new Intent(this,StatusActivity.class);
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
            serviceApi.searchFood("butter");
        }
        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };


}
