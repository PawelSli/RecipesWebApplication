package com.github.pawelsli.recipeswebapplication.entity;

import javax.persistence.*;

@Entity
@Table(name = "steps")
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable=false,unique=true)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id",referencedColumnName="id",nullable=false)
    private Recipe recipe;
    private String description;
    private Long number;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
