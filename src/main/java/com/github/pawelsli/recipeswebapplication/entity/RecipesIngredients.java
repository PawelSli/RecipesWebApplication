package com.github.pawelsli.recipeswebapplication.entity;

import javax.persistence.*;

@Entity
public class RecipesIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id")
    private Recipes recipes;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_id")
    private Ingredients ingredients;

    private Long quantity;
    private IngredientUnit ingredientUnit;

    
}
