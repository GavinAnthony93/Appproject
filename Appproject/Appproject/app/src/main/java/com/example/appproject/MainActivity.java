package com.example.appproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

private Button BtnMainAddUser;
private Button BtnMainFind;
private EditText EditFodevare;
private Button BtnMainAddList;
private ListView List;
private Button BtnMainDetailStatus;
private Button BtnMainStatus;
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

        BtnMainDetailStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                godetail();
            }
        });



    }

    public void godetail()
    {
        Intent intent = new Intent(this,DetailStatusActivity.class);
        startActivity(intent);

    }


}
