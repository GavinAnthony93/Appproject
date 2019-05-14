
package com.example.appproject.Models.FoodDto;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nitrition implements Serializable
{

    @SerializedName("list")
    @Expose
    private List list;
    private final static long serialVersionUID = 3950641418746618565L;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

}
