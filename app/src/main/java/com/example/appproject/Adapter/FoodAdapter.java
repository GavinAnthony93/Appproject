package com.example.appproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appproject.Models.FoodDto.Rootobject;
import com.example.appproject.Models.Nitrition;
import com.example.appproject.R;

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private List<Rootobject> foods;
    private Context context;

    public FoodAdapter(Context context, List<Rootobject> lists)
    {
        this.context= context;
        foods=lists;
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int i) {
        return foods.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        LayoutInflater inflater;
        inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.custumlayout,null);

        Rootobject nitrition = foods.get(i);
        ImageView image = (ImageView)convertView.findViewById(R.id.ImageFood);
        TextView t = (TextView)convertView.findViewById(R.id.TxtFoodName);
        TextView txt = (TextView)convertView.findViewById(R.id.Txt);
        //t.setText(foods.get(i).getFoods()[i].getFood().getDesc().getName());
        //t.setText(nitrition.getFoods()[0].getFood().getDesc().getName());
        t.setText(foods.get(i).getFoods()[0].getFood().getDesc().getName());

        return convertView;
    }
}
