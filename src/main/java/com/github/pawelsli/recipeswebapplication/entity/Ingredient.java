package com.github.pawelsli.recipeswebapplication.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable=false,unique=true)
    private Long id;
    private String title;
    @OneToMany(mappedBy = "ingredient")
    private List<RecipeIngredient> recipeIngredientSet;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RecipeIngredient> getRecipeIngredientSet() {
        return recipeIngredientSet;
    }

    public void setRecipeIngredientSet(List<RecipeIngredient> recipeIngredientSet) {
        this.recipeIngredientSet = recipeIngredientSet;
    }
}
