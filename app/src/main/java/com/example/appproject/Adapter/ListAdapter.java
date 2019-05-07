package com.example.appproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appproject.Models.Nitrition;
import com.example.appproject.R;

import java.util.List;

public class ListAdapter extends BaseAdapter {

private List<Nitrition> nutritions;
private Context context;

public ListAdapter(Context context,List<Nitrition> lists)
{
   this.context= context;
    nutritions=lists;

}

    @Override
    public int getCount() {
        return nutritions.size();
    }

    @Override
    public Object getItem(int i) {
        return nutritions.get(i);
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

        Nitrition nitrition = nutritions.get(i);
        ImageView image = (ImageView)convertView.findViewById(R.id.ImageFood);
        TextView t = (TextView)convertView.findViewById(R.id.TxtFoodName);
        TextView txt = (TextView)convertView.findViewById(R.id.Txt);

        return convertView;
    }
}
