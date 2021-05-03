package com.github.pawelsli.recipeswebapplication.service.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pawelsli.recipeswebapplication.entity.RecipeDifficulty;
import com.github.pawelsli.recipeswebapplication.entity.User;

import java.time.LocalDateTime;

public class AddRecipeDTO {
    private String title;
    private String description;
    private Long min_prep_time;
    private Long max_prep_time;
    private Long time_unit;
    @JsonIgnore
    private LocalDateTime publicationDate;
    private RecipeDifficulty difficulty;
    private Long people_num;
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMin_prep_time() {
        return min_prep_time;
    }

    public void setMin_prep_time(Long min_prep_time) {
        this.min_prep_time = min_prep_time;
    }

    public Long getMax_prep_time() {
        return max_prep_time;
    }

    public void setMax_prep_time(Long max_prep_time) {
        this.max_prep_time = max_prep_time;
    }

    public Long getTime_unit() {
        return time_unit;
    }

    public void setTime_unit(Long time_unit) {
        this.time_unit = time_unit;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public RecipeDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(RecipeDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Long getPeople_num() {
        return people_num;
    }

    public void setPeople_num(Long people_num) {
        this.people_num = people_num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /*public RecipeDTO convertToRecipeDTO(List<StepDTO> stepDTOList,List<RecipeIngredientDTO> recipeIngredientDTOList){

                private long id;
            private List<Step> steps;
            private User user;
            private String title;
            private String description;
            private Long min_prep_time;
            private Long max_prep_time;
            private Long time_unit;
            private LocalDateTime publicationDate;
            private RecipeDifficulty difficulty;
            private Long people_num;
            private String image;
            private Long likes;
            private Long dislikes;
            private List<RecipeIngredient> recipeIngredientSet;

        RecipeDTO recipeDTO=new RecipeDTO();
        recipeDTO.setSteps();
    }*/
}
