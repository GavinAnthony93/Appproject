package com.example.appproject.Models.FoodDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food{
    @SerializedName("food")
    @Expose
    private Food1 food;

    public Food1 getFood() {
        return food;
    }

    public void setFood(Food1 food) {
        this.food = food;
    }
}
