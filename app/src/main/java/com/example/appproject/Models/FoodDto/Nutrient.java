package com.example.appproject.Models.FoodDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutrient{
    @SerializedName("nutrient_id")
    @Expose
    private String nutrient_id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("derivation")
    @Expose
    private String derivation;

    @SerializedName("group")
    @Expose
    private String group;

    public String getNutrient_id() {
        return nutrient_id;
    }

    public void setNutrient_id(String nutrient_id) {
        this.nutrient_id = nutrient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDerivation() {
        return derivation;
    }

    public void setDerivation(String derivation) {
        this.derivation = derivation;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Measure[] getNdbno() {
        return ndbno;
    }

    public void setNdbno(Measure[] ndbno) {
        this.ndbno = ndbno;
    }

    @SerializedName("unit")
    @Expose
    private String unit;

    @SerializedName("value")
    @Expose
    private String value;

    @SerializedName("measures")
    @Expose
    private Measure[] ndbno;
}
