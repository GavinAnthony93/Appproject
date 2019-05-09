package com.example.appproject.Models.FoodDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rootobject{
    @SerializedName("foods")
    @Expose
    private Food[] foods;

    @SerializedName("count")
    @Expose
    private int count;

    public Food[] getFoods() {
        return foods;
    }

    public void setFoods(Food[] foods) {
        this.foods = foods;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNotfound() {
        return notfound;
    }

    public void setNotfound(int notfound) {
        this.notfound = notfound;
    }

    public float getApi() {
        return api;
    }

    public void setApi(float api) {
        this.api = api;
    }

    @SerializedName("notfound")
    @Expose
    private int notfound;

    @SerializedName("api")
    @Expose
    private float api;
}
