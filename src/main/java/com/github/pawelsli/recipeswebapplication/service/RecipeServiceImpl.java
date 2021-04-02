package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.Recipes;
import com.github.pawelsli.recipeswebapplication.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Recipes addRecipe(Recipes recipes) {
        return recipeRepository.save(recipes);
    }

    @Override
    public List<Recipes> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipes> getNewestRecipes() {
        return recipeRepository.findFirst10ByOrderByPublicationDateDesc();
    }

    @Override
    public List<Recipes> getMostPopularRecipes() {
        return null;
    }

    @Override
    public Recipes findRecipyById(Integer id) {
        return recipeRepository.findById(id).orElse(null);
    }
}
