package com.github.pawelsli.recipeswebapplication.service.dto;


import com.github.pawelsli.recipeswebapplication.entity.IngredientUnit;
import com.github.pawelsli.recipeswebapplication.entity.RecipeIngredient;

public class RecipeIngredientDTO {
    private Long id;
    private Long recipeId;
    private Long ingredientId;
    private IngredientUnit ingredientUnit;
    private Long ingredientQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public IngredientUnit getIngredientUnit() {
        return ingredientUnit;
    }

    public void setIngredientUnit(IngredientUnit ingredientUnit) {
        this.ingredientUnit = ingredientUnit;
    }

    public Long getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(Long ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }

    public RecipeIngredient convertToRecipeIngredient(){
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setIngredientUnit(ingredientUnit);
        recipeIngredient.setQuantity(ingredientQuantity);
        return recipeIngredient;
    }
}
