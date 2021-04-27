package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.Recipe;
import com.github.pawelsli.recipeswebapplication.repository.RecipeRepository;
import com.github.pawelsli.recipeswebapplication.service.dto.RecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository=recipeRepository;
    }

    @Override
    public Recipe addRecipe(RecipeDTO recipeDTO) {

        Recipe recipe=new Recipe();
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setDifficulty(recipeDTO.getDifficulty());
        recipe.setDislikes((long) 0);
        recipe.setLikes((long)0);
        recipe.setImage(recipeDTO.getImage());
        recipe.setMax_prep_time(recipeDTO.getMax_prep_time());
        recipe.setMin_prep_time(recipeDTO.getMin_prep_time());
        recipe.setPeople_num(recipeDTO.getPeople_num());
        recipe.setPublicationDate(LocalDateTime.now());

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
