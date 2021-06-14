package com.github.pawelsli.recipeswebapplication.service.dto;

import com.github.pawelsli.recipeswebapplication.entity.Ingredient;

public class IngredientDTO {
    private Long id;
    private String title;

    public IngredientDTO() {
    }

    public IngredientDTO(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.title = ingredient.getTitle();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
