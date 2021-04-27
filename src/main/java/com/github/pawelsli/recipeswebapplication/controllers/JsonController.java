package com.github.pawelsli.recipeswebapplication.controllers;

import com.github.pawelsli.recipeswebapplication.entity.Recipe;
import com.github.pawelsli.recipeswebapplication.entity.User;
import com.github.pawelsli.recipeswebapplication.service.RecipeService;
import com.github.pawelsli.recipeswebapplication.service.UserService;
import com.github.pawelsli.recipeswebapplication.service.dto.RecipeDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "json")
public class JsonController {

    @Autowired
    private UserService userService;
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/showUser")
    public User getUser(@RequestBody String email){
        return userService.findUserByEmail(email);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody UserRegisterDTO userRegisterDTO){
        return userService.createUser(userRegisterDTO);
    }

    @PostMapping("/addDish")
    public Recipe addDish(@RequestBody RecipeDTO recipeDTO){
        return recipeService.addRecipe(recipeDTO);
    }

    @GetMapping("/showDish")
    public Recipe getDish(@RequestBody Integer dishId){
        return recipeService.findRecipyById(dishId);
    }


}
