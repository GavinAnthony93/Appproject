package com.example.appproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailStatusActivity extends AppCompatActivity {
    private ListView nutritions;
    private Button btnOk;
    private ArrayList<String> nutritionValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_status);

        nutritions = findViewById(R.id.listview_details_nutritions);
        btnOk = findViewById(R.id.button_details_ok);

        nutritionValues.add("Iron:      20mg");
        nutritionValues.add("Zink:      10mg");
        nutritionValues.add("Calcium:   20mg");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nutritionValues);
        nutritions.setAdapter(adapter);
    }
}
