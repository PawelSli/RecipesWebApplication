package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.Recipe;
import com.github.pawelsli.recipeswebapplication.service.dto.RecipeDTO;

import java.util.List;

public interface RecipeService {
    public abstract Recipe addRecipe(RecipeDTO recipe);
    public abstract List<Recipe> getRecipes();
    public abstract List<Recipe> getNewestRecipes();
    public abstract List<Recipe> getMostPopularRecipes();
    public abstract Recipe findRecipyById(Integer id);
}
