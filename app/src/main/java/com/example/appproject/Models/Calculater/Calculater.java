package com.example.appproject.Models.Calculater;

import android.content.Intent;

import com.example.appproject.Models.FoodDto.Nutrient;
import com.example.appproject.Models.FoodDto.Rootobject;
import com.example.appproject.Models.VitaminValues;
import com.example.appproject.Services.ServiceApi;

import java.util.ArrayList;

public class Calculater {


    public boolean IsEnoughIron(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(v.getNutrient_id().equals(303))
                {

                    value = Double.valueOf(v.getValue());
                }
            }
            sum += value*var.getunit();
        }

        if(sum > VitaminValues.Iron)
        {
            return true;
        }
        return false;
    }






}

