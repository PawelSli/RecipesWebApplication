package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.Recipes;

import java.util.List;

public interface RecipeService {
    public abstract Recipes addRecipe(Recipes recipes);
    public abstract List<Recipes> getRecipes();
    public abstract List<Recipes> getNewestRecipes();
    public abstract List<Recipes> getMostPopularRecipes();
    public abstract Recipes findRecipyById(Integer id);
}
