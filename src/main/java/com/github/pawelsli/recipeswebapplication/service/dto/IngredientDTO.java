package com.github.pawelsli.recipeswebapplication.service.dto;

import com.github.pawelsli.recipeswebapplication.entity.Ingredient;

public class IngredientDTO {
    private long id;
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Ingredient convertToIngredient(){
        Ingredient ingredient = new Ingredient();
        ingredient.setTitle(title);
        return ingredient;
    }
}
