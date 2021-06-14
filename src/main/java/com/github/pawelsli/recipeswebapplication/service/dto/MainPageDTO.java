package com.github.pawelsli.recipeswebapplication.service.dto;

import java.util.List;

public class MainPageDTO {
    private List<CompleteRecipeDTO> randomDishes;
    private List<CompleteRecipeDTO> bestDishes;
    private List<CompleteRecipeDTO> newestDishes;

    public List<CompleteRecipeDTO> getNewestDishes() {
        return newestDishes;
    }

    public void setNewestDishes(List<CompleteRecipeDTO> newestDishes) {
        this.newestDishes = newestDishes;
    }

    public List<CompleteRecipeDTO> getBestDishes() {
        return bestDishes;
    }

    public void setBestDishes(List<CompleteRecipeDTO> bestDishes) {
        this.bestDishes = bestDishes;
    }

    public List<CompleteRecipeDTO> getRandomDishes() {
        return randomDishes;
    }

    public void setRandomDishes(List<CompleteRecipeDTO> randomDishes) {
        this.randomDishes = randomDishes;
    }

    public MainPageDTO(List<CompleteRecipeDTO> randomDishes,
                       List<CompleteRecipeDTO> bestDishes,
                       List<CompleteRecipeDTO> newestDishes) {

        this.newestDishes = newestDishes;
        this.bestDishes = bestDishes;
        this.randomDishes = randomDishes;
    }
}
