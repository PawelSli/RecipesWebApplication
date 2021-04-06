package com.github.pawelsli.recipeswebapplication.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="recipes")
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable=false,unique=true)
    private long id;

    @OneToMany(mappedBy = "recipe")
    private Set<Steps> steps;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users user;

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

    @OneToMany(mappedBy = "recipe")
    private Set<RecipesIngredients> recipesIngredientsSet;

    public Set<Steps> getSteps() {
        return steps;
    }

    public void setSteps(Set<Steps> stepsList) {
        this.steps = stepsList;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Set<RecipesIngredients> getRecipesIngredientsSet() {
        return recipesIngredientsSet;
    }

    public void setRecipesIngredientsSet(Set<RecipesIngredients> recipesIngredientsSet) {
        this.recipesIngredientsSet = recipesIngredientsSet;
    }

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

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    public Long getTime_unit() {
        return time_unit;
    }

    public void setTime_unit(Long time_unit) {
        this.time_unit = time_unit;
    }
}
