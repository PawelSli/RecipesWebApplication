package com.github.pawelsli.recipeswebapplication.service.dto;

import java.util.List;

public class MainPageDTO {
    private List<RecipeDTO> newestDishes;
    private List<RecipeDTO> bestDishes;

    public List<RecipeDTO> getNewestDishes() {
        return newestDishes;
    }

    public void setNewestDishes(List<RecipeDTO> newestDishes) {
        this.newestDishes = newestDishes;
    }

    public List<RecipeDTO> getBestDishes() {
        return bestDishes;
    }

    public void setBestDishes(List<RecipeDTO> bestDishes) {
        this.bestDishes = bestDishes;
    }
}
