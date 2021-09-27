package com.techelevator.dao;

import com.techelevator.model.Food;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFoodDao implements FoodDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcFoodDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Food> getAllFood() {
        List<Food> food = new ArrayList<>();
        String sql = "select * from foods";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            Food userFood = new Food();
            userFood = mapToRowFood(results);
            food.add(userFood);
        }
        return food;
    }

    @Override
    public Food getFoodById(int id) {
        Food food = null;
        String sql = "select * from foods where food_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()) {
            food = mapToRowFood(results);
        }

        return food;
    }


    public List<Food> getFoodByName(String name) {
        List<Food> foods = new ArrayList<>();
        String sql = "select * from foods where LOWER(food_name) like LOWER(?) OR LOWER(food_name) like LOWER(?)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%"+name+"%","% "+name+" %");

        while(results.next()) {
            foods.add(mapToRowFood(results));
        }
        return foods;
    }

    private Food mapToRowFood(SqlRowSet results) {
        Food food = new Food();
        food.setFood_id(results.getInt("food_id"));
        food.setFood_name(results.getString("food_name"));
        food.setCalories(results.getInt("calories"));
        food.setFat(results.getBigDecimal("fat"));
        food.setProtein(results.getBigDecimal("protein"));
        food.setCarbohydrate(results.getBigDecimal("carbohydrate"));
        food.setServing_size(results.getString("serving_size"));
        food.setFood_group(results.getString("food_group"));

        return food;
    }



}


