package com.github.pawelsli.recipeswebapplication.controllers;

import com.github.pawelsli.recipeswebapplication.repository.UserRepository;
import com.github.pawelsli.recipeswebapplication.security.UserDetailsImpl;
import com.github.pawelsli.recipeswebapplication.service.RecipeService;
import com.github.pawelsli.recipeswebapplication.service.dto.AddRecipeDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.DifficultyAndUnitsDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.MainPageDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.RecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
public class RecipeController {
    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<MainPageDTO> getMainPageDishes() {
        return ResponseEntity.ok(recipeService.getMainPageDishes());
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<RecipeDTO> getRecipe(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.findRecipeById(id));
    }

    @GetMapping("/addDish")
    public ResponseEntity<DifficultyAndUnitsDTO> getDifficultyAndUnits() {
        return ResponseEntity.ok(recipeService.getDifficultyAndUnits());
    }

    @PostMapping("/addDish")
    public ResponseEntity<?> uploadDish(@RequestParam MultipartFile file,
                                        @Validated @ModelAttribute AddRecipeDTO addRecipeDTO,
                                        @AuthenticationPrincipal UserDetailsImpl user) {
        addRecipeDTO.setUserID(user.getId());
        recipeService.addRecipe(file, addRecipeDTO);

        return ResponseEntity.ok("Nice");
    }


}
