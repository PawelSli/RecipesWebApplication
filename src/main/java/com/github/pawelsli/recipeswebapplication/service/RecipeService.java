package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.IngredientUnit;
import com.github.pawelsli.recipeswebapplication.entity.Recipe;
import com.github.pawelsli.recipeswebapplication.entity.RecipeDifficulty;
import com.github.pawelsli.recipeswebapplication.service.dto.AddRecipeDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.DifficultyAndUnitsDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.MainPageDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.RecipeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RecipeService {
    public abstract Void addRecipe(MultipartFile file,AddRecipeDTO addRecipeDTO);
    public abstract List<RecipeDTO> getRecipes();
    public abstract List<RecipeDTO> getNewestRecipes();
    public abstract List<RecipeDTO> getMostPopularRecipes();
    public abstract MainPageDTO getMainPageDishes();
    public abstract RecipeDTO findRecipeById(Long id);
    public abstract DifficultyAndUnitsDTO getDifficultyAndUnits();
}
