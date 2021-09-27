package com.techelevator.dao;

import com.techelevator.model.Food;

import java.util.List;

public interface FoodDao {
    List<Food> getAllFood();
    Food getFoodById(int id);
    List<Food> getFoodByName(String name);
}