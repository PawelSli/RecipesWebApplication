package com.github.pawelsli.recipeswebapplication.service.dto;

import com.github.pawelsli.recipeswebapplication.entity.RecipeDifficulty;
import com.sun.istack.NotNull;

import java.time.LocalDateTime;

public class RecipeDTO {
    @NotNull
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String description;
    @NotNull
    private Long max_prep_time;
    @NotNull
    private Long min_prep_time;
    @NotNull
    private Long time_unit;
    @NotNull
    private RecipeDifficulty difficulty;
    @NotNull
    private Long people_num;
    @NotNull
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getMax_prep_time() {
        return max_prep_time;
    }

    public void setMax_prep_time(Long max_prep_time) {
        this.max_prep_time = max_prep_time;
    }

    public Long getMin_prep_time() {
        return min_prep_time;
    }

    public void setMin_prep_time(Long min_prep_time) {
        this.min_prep_time = min_prep_time;
    }

    public Long getTime_unit() {
        return time_unit;
    }

    public void setTime_unit(Long time_unit) {
        this.time_unit = time_unit;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
