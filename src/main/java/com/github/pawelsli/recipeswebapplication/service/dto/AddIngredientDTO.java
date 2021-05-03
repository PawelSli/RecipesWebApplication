package com.github.pawelsli.recipeswebapplication.service.dto;

public class AddIngredientDTO {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IngredientDTO convertToIngredientDTO(){
        IngredientDTO ingredientDTO=new IngredientDTO();
        ingredientDTO.setTitle(title);
        return ingredientDTO;
    }
}
