package com.example.appproject.Models.FoodDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Desc{
    @SerializedName("ndbno")
    @Expose
    private String ndbno;

    @SerializedName("name")
    @Expose
    private String name;

    public String getNdbno() {
        return ndbno;
    }

    public void setNdbno(String ndbno) {
        this.ndbno = ndbno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    @SerializedName("ds")
    @Expose
    private String ds;

    @SerializedName("manu")
    @Expose
    private String manu;

    @SerializedName("ru")
    @Expose
    private String ru;
}
