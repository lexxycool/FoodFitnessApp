package com.techelevator.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class Food {
    @Min(value=0)
    private int food_id;
    @NotBlank
    private String food_name;
    @Positive
    private int calories;
    @Positive
    private BigDecimal fat;
    @Positive
    private BigDecimal protein;
    @Positive
    private BigDecimal carbohydrate;
    private String serving_size;
    private String food_group;


    public Food(int food_id, String food_name, int calories, BigDecimal fat, BigDecimal protein, BigDecimal carbohydrate, String serving_size, String food_group) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.serving_size = serving_size;
        this.food_group = food_group;
    }

    public Food() {

    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getCalories(){
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public BigDecimal getFat() {
        return fat;
    }

    public void setFat(BigDecimal fat) {
        this.fat = fat;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(BigDecimal carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public String getServing_size() {
        return serving_size;
    }

    public void setServing_size(String serving_size) {
        this.serving_size = serving_size;
    }

    public String getFood_group() {
        return food_group;
    }

    public void setFood_group(String food_group) {
        this.food_group = food_group;
    }



}
