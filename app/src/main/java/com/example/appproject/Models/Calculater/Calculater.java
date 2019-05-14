package com.example.appproject.Models.Calculater;

import android.util.Log;

import com.example.appproject.Models.FoodDto.Nutrient;
import com.example.appproject.Models.FoodDto.Rootobject;
import com.example.appproject.Models.VitaminData.VitaminValues;

import java.util.ArrayList;

public class Calculater {


    public boolean IsEnoughIron(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (303)) {
                    value = Double.valueOf(v.getValue());
                }
            }
            sum += value * var.getunit();

            Log.d("vitaminvaerdi: ", String.valueOf(value));
            double percent = (sum / VitaminValues.Iron) * 100;
            Log.d("percent", String.valueOf(percent));
        }

        if (sum > VitaminValues.Iron) {
            return true;
        }
        return false;
    }

    public boolean IsEnoughVitaminA(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (318)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();


            }

            if (sum > VitaminValues.VitaminA) {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughVitaminC(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (401)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();


            }

            if (sum > VitaminValues.VitaminC) {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughVitaminD(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (328)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            if (sum > VitaminValues.VitaminD) {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughVitaminB6(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (415)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            if (sum > VitaminValues.VitaminB6) {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughVitaminB12(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (418)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            if (sum > VitaminValues.VitaminB12) {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughNiacin(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (406)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            if (sum > VitaminValues.Niacin) {
                return true;
            }

        }
        return false;
    }


    public boolean IsEnoughCalcium(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (301)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            if (sum > VitaminValues.Calcium) {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughMagnesium(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (304)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            if (sum > VitaminValues.Magnesium) {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughRiboflavin(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (405)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            if (sum > VitaminValues.Riboflavin) {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughVitaminE(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (323)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            if (sum > VitaminValues.VitaminE) {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughZink(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (309)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            if (sum > VitaminValues.Zink) {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughKobber(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (304)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            if (sum > VitaminValues.Kobber) {
                return true;
            }

        }
        return false;
    }

    public boolean IsEnoughThiamin(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (404)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            if (sum > VitaminValues.Thiamin) {
                return true;
            }

        }
        return false;
    }

    public void IsEnoughIronPercent(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (303)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }
            double percent = (sum / VitaminValues.Iron) * 100;
            Log.d("percent", String.valueOf(percent));

        }
    }

    public void IsEnoughVitaminAPercent(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (318)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }
            double percent = (sum / VitaminValues.VitaminA) * 100;
            Log.d("percent", String.valueOf(percent));

        }
    }


    public void IsEnoughVitaminCPercent(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (401)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }
            double percent = (sum / VitaminValues.VitaminC) * 100;
            Log.d("percent", String.valueOf(percent));

        }
    }

    public void IsEnoughVitaminDPercent(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (324)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }
            double percent = (sum / VitaminValues.VitaminD) * 100;
            Log.d("percent", String.valueOf(percent));

        }
    }

    public void IsEnoughVitaminB6Percent(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (415)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }
            double percent = (sum / VitaminValues.VitaminB6) * 100;
            Log.d("percent", String.valueOf(percent));

        }
    }

    public void IsEnoughVitaminB12Percent(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (418)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }
            double percent = (sum / VitaminValues.VitaminB12) * 100;
            Log.d("percent", String.valueOf(percent));

        }
    }

    public void IsEnoughVitaminNiacin(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (406)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }
            double percent = (sum / VitaminValues.Niacin) * 100;
            Log.d("percent", String.valueOf(percent));

        }
    }

    public void IsEnoughPercentCalcium(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (301)) {
                    value = Double.valueOf(v.getValue());
                }

                sum += value * var.getunit();

            }

            double percent = (sum / VitaminValues.Calcium) * 100;
            Log.d("percent", String.valueOf(percent));

        }

    }

    public void IsEnoughPercentMagnesium(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (304)) {
                    value = Double.valueOf(v.getValue());
                }
                sum += value * var.getunit();
            }
            double percent = (sum / VitaminValues.Magnesium) * 100;
            Log.d("percent", String.valueOf(percent));

        }

    }

    public void IsEnoughPercentRiboflavin(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (405)) {
                    value = Double.valueOf(v.getValue());
                }
                sum += value * var.getunit();
            }
            double percent = (sum / VitaminValues.Riboflavin) * 100;
            Log.d("percent", String.valueOf(percent));

        }

    }


    public void IsEnoughPercentVitaminE(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (323)) {
                    value = Double.valueOf(v.getValue());
                }
                sum += value * var.getunit();
            }
            double percent = (sum / VitaminValues.VitaminE) * 100;
            Log.d("percent", String.valueOf(percent));

        }

    }

    public void IsEnoughPercentZink(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (309)) {
                    value = Double.valueOf(v.getValue());
                }
                sum += value * var.getunit();
            }
            double percent = (sum / VitaminValues.Zink) * 100;
            Log.d("percent", String.valueOf(percent));

        }

    }


    public void IsEnoughPercentThiamin(ArrayList<Rootobject> foods) {
        double sum = 0;

        for (Rootobject var : foods) {
            Nutrient[] allnutrients = var.getFoods()[0].getFood().getNutrients();
            double value = 0;
            for (Nutrient v : allnutrients) {
                if (Integer.valueOf(v.getNutrient_id()) == (404)) {
                    value = Double.valueOf(v.getValue());
                }
                sum += value * var.getunit();
            }
            double percent = (sum / VitaminValues.Thiamin) * 100;
            Log.d("percent", String.valueOf(percent));

        }

    }



}

