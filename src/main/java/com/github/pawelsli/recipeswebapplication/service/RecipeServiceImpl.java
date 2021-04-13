package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.Recipe;
import com.github.pawelsli.recipeswebapplication.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository=recipeRepository;
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> getNewestRecipes() {
        return recipeRepository.findFirst10ByOrderByPublicationDateDesc();
    }

    @Override
    public List<Recipe> getMostPopularRecipes() {
        return null;
    }

    @Override
    public Recipe findRecipyById(Integer id) {
        return recipeRepository.findById(id).orElse(null);
    }
}
