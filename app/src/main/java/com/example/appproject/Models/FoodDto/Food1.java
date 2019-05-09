package com.example.appproject.Models.FoodDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food1{
    @SerializedName("sr")
    @Expose
    private String sr;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("desc")
    @Expose
    private Desc desc;

    @SerializedName("nutrients")
    @Expose
    private Nutrient[] nutrients;

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Desc getDesc() {
        return desc;
    }

    public void setDesc(Desc desc) {
        this.desc = desc;
    }

    public Nutrient[] getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrient[] nutrients) {
        this.nutrients = nutrients;
    }

    public Footnote[] getFootnotes() {
        return footnotes;
    }

    public void setFootnotes(Footnote[] footnotes) {
        this.footnotes = footnotes;
    }

    @SerializedName("footnotes")
    @Expose
    private Footnote[] footnotes;
}
