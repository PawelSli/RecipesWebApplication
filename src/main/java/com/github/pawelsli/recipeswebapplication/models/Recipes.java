package com.github.pawelsli.recipeswebapplication.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

//@Entity
class Recipes {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String description;
    private int min_prep_time;
    private int max_prep_time;
    private LocalDateTime created_at;
    private int difficulty;
    private int people_num;

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

    public int getMin_prep_time() {
        return min_prep_time;
    }

    public void setMin_prep_time(int min_prep_time) {
        this.min_prep_time = min_prep_time;
    }

    public int getMax_prep_time() {
        return max_prep_time;
    }

    public void setMax_prep_time(int max_prep_time) {
        this.max_prep_time = max_prep_time;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getPeople_num() {
        return people_num;
    }

    public void setPeople_num(int people_num) {
        this.people_num = people_num;
    }
}
