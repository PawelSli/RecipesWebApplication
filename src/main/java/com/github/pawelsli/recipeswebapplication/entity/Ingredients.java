package com.github.pawelsli.recipeswebapplication.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable=false,unique=true)
    private long id;
    private String title;
    @OneToMany(mappedBy = "ingredient")
    private Set<RecipesIngredients> recipesIngredientsSet;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<RecipesIngredients> getRecipesIngredientsSet() {
        return recipesIngredientsSet;
    }

    public void setRecipesIngredientsSet(Set<RecipesIngredients> recipesIngredientsSet) {
        this.recipesIngredientsSet = recipesIngredientsSet;
    }
}
