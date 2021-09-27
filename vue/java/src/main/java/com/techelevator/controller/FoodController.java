package com.techelevator.controller;

import com.techelevator.Exception.FoodNotFoundException;
import com.techelevator.dao.FoodDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Food;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path="/all-foods")
public class FoodController {

    @Autowired
    FoodDao dao;

    @Autowired
    UserDao userDao;

    @RequestMapping(path="", method = RequestMethod.GET)
    public List<Food> getAllFoods() {
        List<Food> allFoods = dao.getAllFood();
        return allFoods;

    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Food getFood(@Valid @PathVariable int id) throws FoodNotFoundException {
        Food food = dao.getFoodById(id);

        return food;
        
    }

    @RequestMapping(path="/filter", method = RequestMethod.GET)
    public  List<Food> getFood(@Valid @RequestParam String name) throws FoodNotFoundException {
        List<Food> food = dao.getFoodByName(name);
        return food;

    }

    @RequestMapping(path="/all-users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        List<User> allUsers = userDao.findAll();

        return allUsers;
    }

    @RequestMapping(path="/user/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long userId) {
        User user = userDao.getUserById(userId);

        return user;
    }


}
