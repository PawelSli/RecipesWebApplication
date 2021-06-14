package com.github.pawelsli.recipeswebapplication.service.dto;

import com.github.pawelsli.recipeswebapplication.entity.IngredientUnit;
import com.github.pawelsli.recipeswebapplication.entity.RecipeDifficulty;

import java.util.List;

public class DifficultyAndUnitsDTO {
    private List<IngredientUnit> ingredientUnitList;
    private List<RecipeDifficulty> recipeDifficulties;

    public DifficultyAndUnitsDTO(List<IngredientUnit> ingredientUnitList,
                                 List<RecipeDifficulty> recipeDifficulties) {
        this.ingredientUnitList = ingredientUnitList;
        this.recipeDifficulties = recipeDifficulties;
    }

    public List<IngredientUnit> getIngredientUnitList() {
        return ingredientUnitList;
    }

    public void setIngredientUnitList(List<IngredientUnit> ingredientUnitList) {
        this.ingredientUnitList = ingredientUnitList;
    }

    public List<RecipeDifficulty> getRecipeDifficulties() {
        return recipeDifficulties;
    }

    public void setRecipeDifficulties(List<RecipeDifficulty> recipeDifficulties) {
        this.recipeDifficulties = recipeDifficulties;
    }
}
