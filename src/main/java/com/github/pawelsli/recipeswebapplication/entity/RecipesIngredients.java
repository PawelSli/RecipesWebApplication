package com.github.pawelsli.recipeswebapplication.entity;

import javax.persistence.*;


@Entity
public class RecipesIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable=false,unique=true)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id",referencedColumnName="id",nullable=false,unique=true)
    private Recipes recipe;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_id",referencedColumnName="id",nullable=false,unique=true)
    private Ingredients ingredient;

    private Long quantity;
    private IngredientUnit ingredientUnit;

    
}
