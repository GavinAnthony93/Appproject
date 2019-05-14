package com.example.appproject.Models.Calculater;

import android.util.Log;

import com.example.appproject.Models.FoodDto.Nutrient;
import com.example.appproject.Models.FoodDto.Rootobject;
import com.example.appproject.Models.VitaminData.VitaminValues;

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
                if(Integer.valueOf(v.getNutrient_id())==(303))
                {
                    value = Double.valueOf(v.getValue());
                }
            }
            sum += value*var.getunit();

            Log.d("vitaminvaerdi: ", String.valueOf(value));
        }

        if(sum > VitaminValues.Iron)
        {
            return true;
        }
        return false;
    }

    public boolean IsEnoughVitaminA(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(401))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();


            }

            if(sum > VitaminValues.VitaminA)
            {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughVitaminC(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(401))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();


            }

            if(sum > VitaminValues.VitaminC)
            {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughVitaminD(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(328))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();

            }

            if(sum > VitaminValues.VitaminD)
            {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughVitaminB6(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(304))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();

            }

            if(sum > VitaminValues.VitaminB6)
            {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughVitaminB12(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(418))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();

            }

            if(sum > VitaminValues.VitaminB12)
            {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughNiacin(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(406))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();

            }

            if(sum > VitaminValues.Niacin)
            {
                return true;
            }

        }
        return false;
    }



    public boolean IsEnoughCalcium(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(301))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();

            }

            if(sum > VitaminValues.Calcium)
            {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughMagnesium(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(304))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();

            }

            if(sum > VitaminValues.Magnesium)
            {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughRiboflavin(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(405))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();

            }

            if(sum > VitaminValues.Riboflavin)
            {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughVitaminE(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(323))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();

            }

            if(sum > VitaminValues.VitaminE)
            {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughZink(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(309))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();

            }

            if(sum > VitaminValues.Zink)
            {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughKobber(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(304))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();

            }

            if(sum > VitaminValues.Kobber)
            {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughThiamin(ArrayList<Rootobject> foods)
    {
        double sum = 0;

        for(Rootobject var: foods){
            Nutrient[]allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for(Nutrient v : allnutrients)
            {
                if(Integer.valueOf(v.getNutrient_id())==(404))
                {
                    value = Double.valueOf(v.getValue());
                }

                sum += value*var.getunit();

            }

            if(sum > VitaminValues.Thiamin)
            {
                return true;
            }

        }
        return false;
    }



}

