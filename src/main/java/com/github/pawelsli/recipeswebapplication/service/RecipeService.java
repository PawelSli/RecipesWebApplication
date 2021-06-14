package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.User;
import com.github.pawelsli.recipeswebapplication.service.dto.CompleteRecipeDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.DifficultyAndUnitsDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.MainPageDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.RecipeDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RecipeService {
    Void addRecipe(MultipartFile file, CompleteRecipeDTO completeRecipeDTO);
    List<RecipeDTO> getRecipes();
    List<CompleteRecipeDTO> getNewestRecipes();
    List<CompleteRecipeDTO> getMostPopularRecipes();
    List<CompleteRecipeDTO> getRandomRecipes();
    MainPageDTO getMainPageDishes();
    CompleteRecipeDTO findRecipeById(Long id);
    List<CompleteRecipeDTO> getUserRecipes(User user);
    DifficultyAndUnitsDTO getDifficultyAndUnits();
    List<CompleteRecipeDTO> searchRecipes(String query);
}
