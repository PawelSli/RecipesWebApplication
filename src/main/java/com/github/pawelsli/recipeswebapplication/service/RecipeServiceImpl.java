package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.Recipe;
import com.github.pawelsli.recipeswebapplication.repository.RecipeRepository;
import com.github.pawelsli.recipeswebapplication.service.dto.AddRecipeDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.MainPageDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.RecipeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    private RecipeRepository recipeRepository;
    private final static Logger log = LoggerFactory.getLogger(RecipeServiceImpl.class);

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository=recipeRepository;
    }

    @Override
    public Void addRecipe(AddRecipeDTO addRecipeDTO) {
        return null;
    }

    @Override
    public List<RecipeDTO> getRecipes() {
        return null;
    }

    @Override
    public List<RecipeDTO> getNewestRecipes() {
        return null;
    }

    @Override
    public List<RecipeDTO> getMostPopularRecipes() {
        return null;
    }

    @Override
    public RecipeDTO findRecipeById(Long id) {
        return null;
    }

    @Override
    public MainPageDTO getMainPageDishes() {
        return null;
    }
}
