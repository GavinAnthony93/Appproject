package com.example.appproject.Models.FoodDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Footnote{
    @SerializedName("idv")
    @Expose
    private int idv;

    @SerializedName("desc")
    @Expose
    private String desc;
}