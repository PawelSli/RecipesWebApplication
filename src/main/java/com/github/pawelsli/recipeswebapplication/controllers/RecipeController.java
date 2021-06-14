package com.github.pawelsli.recipeswebapplication.controllers;

import com.github.pawelsli.recipeswebapplication.security.UserDetailsImpl;
import com.github.pawelsli.recipeswebapplication.service.RecipeService;
import com.github.pawelsli.recipeswebapplication.service.UserService;
import com.github.pawelsli.recipeswebapplication.service.dto.CompleteRecipeDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.DifficultyAndUnitsDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.MainPageDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.RecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RecipeController {
    private RecipeService recipeService;
    private UserService userService;

    @Autowired
    public RecipeController(RecipeService recipeService,UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<MainPageDTO> getMainPage() {
        MainPageDTO mainPageDTO = recipeService.getMainPageDishes();
        return ResponseEntity.ok(mainPageDTO);
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<CompleteRecipeDTO> getRecipeById(@PathVariable Long id) {
        CompleteRecipeDTO recipe = recipeService.findRecipeById(id);
        return ResponseEntity.ok(recipe);
    }


    @GetMapping("/addDish")
    public ResponseEntity<DifficultyAndUnitsDTO> getDifficultyAndUnits() {
        return ResponseEntity.ok(recipeService.getDifficultyAndUnits());
    }

    @GetMapping("/search")
    public ResponseEntity<List<CompleteRecipeDTO>> searchRecipes(@RequestParam String query) {
        return ResponseEntity.ok(recipeService.searchRecipes(query));
    }

    @PostMapping("/addDish")
    public ResponseEntity<?> uploadDish(@RequestParam MultipartFile file,
                                        @Validated @ModelAttribute CompleteRecipeDTO completeRecipeDTO,
                                        @AuthenticationPrincipal UserDetailsImpl user) {
        System.out.println("HMMMMM123");
        completeRecipeDTO.setUserID(user.getId());
        recipeService.addRecipe(file, completeRecipeDTO);

        return ResponseEntity.ok("Nice");
    }

    @GetMapping("/profile")
    public ResponseEntity<List<CompleteRecipeDTO>> getUserRecipes(@AuthenticationPrincipal UserDetailsImpl user){
        return ResponseEntity.ok(recipeService.getUserRecipes(userService.getUser(user.getId()).orElseThrow()));
    }



}
