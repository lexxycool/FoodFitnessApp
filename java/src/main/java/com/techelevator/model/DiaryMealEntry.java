package com.techelevator.model;

import java.time.LocalDate;

public class DiaryMealEntry {

    private int diaryMealEntryId;
    private int diaryId;
    private LocalDate diaryMealEntryDate;
    private int diaryMealTypeId;
    private int foodId;
    private String servingSize;
    private double numberOfServings;

    public int getDiaryMealEntryId() {
        return diaryMealEntryId;
    }

    public void setDiaryMealEntryId(int diaryMealEntryId) {
        this.diaryMealEntryId = diaryMealEntryId;
    }

    public int getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(int diaryId) {
        this.diaryId = diaryId;
    }

    public LocalDate getDiaryMealEntryDate() {
        return diaryMealEntryDate;
    }

    public void setDiaryMealEntryDate(LocalDate diaryMealEntryDate) {
        this.diaryMealEntryDate = diaryMealEntryDate;
    }

    public int getDiaryMealTypeId() {
        return diaryMealTypeId;
    }

    public void setDiaryMealTypeId(int diaryMealTypeId) {
        this.diaryMealTypeId = diaryMealTypeId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public double getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(double numberOfServings) {
        this.numberOfServings = numberOfServings;
    }
}
