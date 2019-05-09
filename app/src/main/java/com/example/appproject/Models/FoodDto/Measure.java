package com.example.appproject.Models.FoodDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class  Measure{
    @SerializedName("label")
    @Expose
    private String label;

    @SerializedName("eqv")
    @Expose
    private float eqv;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getEqv() {
        return eqv;
    }

    public void setEqv(float eqv) {
        this.eqv = eqv;
    }

    public String getEunit() {
        return eunit;
    }

    public void setEunit(String eunit) {
        this.eunit = eunit;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @SerializedName("eunit")
    @Expose
    private String eunit;

    @SerializedName("qty")
    @Expose
    private float qty;

    @SerializedName("value")
    @Expose
    private String value;
}
