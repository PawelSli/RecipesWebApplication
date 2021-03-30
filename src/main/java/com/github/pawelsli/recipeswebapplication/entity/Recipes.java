package com.github.pawelsli.recipeswebapplication.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int min_prep_time;
    @Column(nullable = false)
    private int max_prep_time;
    @Column(nullable = false)
    private LocalDateTime publicationDate;
    @Column(nullable = false)
    private int difficulty;
    @Column(nullable = false)
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


    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
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
