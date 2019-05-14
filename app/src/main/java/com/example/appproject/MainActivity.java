package com.example.appproject;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appproject.Adapter.FoodAdapter;
import com.example.appproject.Models.DialogBox.DialogBox;
import com.example.appproject.Models.FoodDto.Rootobject;
import com.example.appproject.Services.ServiceApi;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogBox.DialogListener, PopupMenu.OnMenuItemClickListener {

    private Button BtnMainAddList;
    private ListView FoodList;
    private Button BtnMainDetailStatus;
    private Button BtnMainStatus;
    private Button BtnUserInfo;
    private EditText EditUnit;
    private TextView TxtMainName;
    private TextView TxtLastName;
    private TextView TxtHeight;
    private TextView TxtWeight;
    private ArrayList Flist;
    private ProgressDialog progressdialog;
    ServiceApi serviceApi;
    boolean mBound = false;
    Rootobject foods;
    private FoodAdapter adapter;
    private ArrayList<Rootobject> nitritionArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foods = new Rootobject();
        final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.vegetables,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        TxtMainName = (TextView) findViewById(R.id.TxtMainName);
        TxtHeight = (TextView) findViewById(R.id.TxtHeight);
        TxtLastName = (TextView) findViewById(R.id.TxtLastName);
        EditUnit = (EditText)findViewById(R.id.EditUnit);
        BtnMainAddList = (Button) findViewById(R.id.BtnMainAddList);
        BtnUserInfo = (Button)findViewById(R.id.BtnUserInfo);
        FoodList = (ListView) findViewById(R.id.List);
        BtnMainDetailStatus = (Button) findViewById(R.id.BtnMainDetailStatus);
        BtnMainStatus = (Button) findViewById(R.id.BtnMainStatus);
        TxtWeight = (TextView) findViewById(R.id.TxtWeight);


        BtnMainAddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(MainActivity.this,FoodAdapter.class);
                int unit = Integer.valueOf(EditUnit.getText().toString());
                progressdialog = new ProgressDialog(MainActivity.this);
                String spinnertext = spinner.getSelectedItem().toString();
                String textsurname = TxtMainName.getText().toString();
                String textlastname = TxtLastName.getText().toString();


                if(spinnertext.equals("")|| unit==0)
                {
                    Toast.makeText(MainActivity.this,"Please Enter!",Toast.LENGTH_SHORT).show();
                }

                else if (spinnertext.equals("Orange"))
                {
                    serviceApi.searchFood("09205", unit);
                }

                else if (spinnertext.equals("Cucumber"))
                {
                    serviceApi.searchFood("11205", unit);
                }

                else if (spinnertext.equals("Red Tomato"))
                {
                    serviceApi.searchFood("11529", unit);
                }

                else if (spinnertext.equals("Carrot"))
                {
                    serviceApi.searchFood("11124", unit);
                }

                else if (spinnertext.equals("Baby Carrot"))
                {
                    serviceApi.searchFood("11960", unit);
                }

                else if (spinnertext.equals("Potato"))
                {
                    serviceApi.searchFood("11362", unit);
                }

                else if (spinnertext.equals("Yellow Tomato"))
                {
                    serviceApi.searchFood("11696", unit);
                }

                else if (spinnertext.equals("Green Tomato"))
                {
                    serviceApi.searchFood("11527", unit);
                }

                else if (spinnertext.equals("Orange Tomato"))
                {
                    serviceApi.searchFood("11695", unit);
                }

                else if (spinnertext.equals("Artichokes"))
                {
                    serviceApi.searchFood("11007", unit);
                }

                else if (spinnertext.equals("Asparagus"))
                {
                    serviceApi.searchFood("11011", unit);
                }

                else if (spinnertext.equals("Eggplant"))
                {
                    serviceApi.searchFood("11209", unit);
                }

                else if (spinnertext.equals("Avocado"))
                {
                    serviceApi.searchFood("09038", unit);
                }

                else if (spinnertext.equals("Celery"))
                {
                    serviceApi.searchFood("11143", unit);
                }

                else if (spinnertext.equals("Nuts"))
                {
                    serviceApi.searchFood("112087", unit);
                }

                else if (spinnertext.equals("Cauliflower"))
                {
                    serviceApi.searchFood("11135", unit);
                }

                else if (spinnertext.equals("Pasnips"))
                {
                    serviceApi.searchFood("11298", unit);
                }

                else if (spinnertext.equals("Pumpkin"))
                {
                    serviceApi.searchFood("45206215", unit);
                }

                else if (spinnertext.equals("Red bell pepper"))
                {
                    serviceApi.searchFood("45066049", unit);
                }

                else if (spinnertext.equals("Radishes"))
                {
                    serviceApi.searchFood("11429", unit);
                }


                //progressdialog.setMessage("Searching for food");
               // progressdialog.show();

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

    public void showPopup(View v)
    {
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem Item) {
        switch (Item.getItemId()){
            case R.id.AddUser:
                openDialog();
                return true;
            case R.id.FindUser:
                return true;
                default:
                    return false;
        }
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
    public void applyTexts(String name, String last, String height, String weight) {
        TxtMainName.setText("Surname:" + name);
        TxtLastName.setText("Lastname: " + last);
        TxtHeight.setText("Height:" + height + "m");
        TxtWeight.setText("Weight: " + weight + "kg");

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
        adapter = new FoodAdapter(this, nitritionArrayList ); // TODO avoid creating new adapter here
        FoodList.setAdapter(adapter);
    }
    private BroadcastReceiver listener = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateUI();
        }
    };

}


