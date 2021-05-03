package com.github.pawelsli.recipeswebapplication.controllers;

import com.github.pawelsli.recipeswebapplication.repository.UserRepository;
import com.github.pawelsli.recipeswebapplication.service.RecipeService;
import com.github.pawelsli.recipeswebapplication.service.dto.MainPageDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.RecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class RecipeController {
    private RecipeService recipeService;
    private UserRepository userRepository;

    @Autowired
    public RecipeController(RecipeService recipeService,UserRepository userRepository){
        this.recipeService=recipeService;
        this.userRepository=userRepository;
    }

    @GetMapping
    public ResponseEntity<MainPageDTO> getMainPageDishes(){
        return ResponseEntity.ok(recipeService.getMainPageDishes());
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<RecipeDTO> getRecipe(@PathVariable Long id){
        return ResponseEntity.ok(recipeService.findRecipeById(id));
    }

    @GetMapping("/addDish")
    public ResponseEntity<String> addRecipe(){
        return ResponseEntity.ok("HMMM");
    }


}
