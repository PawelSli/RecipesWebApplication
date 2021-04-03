package com.github.pawelsli.recipeswebapplication.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "ingredients")
    Set<RecipesIngredients> recipesIngredientsSet;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
