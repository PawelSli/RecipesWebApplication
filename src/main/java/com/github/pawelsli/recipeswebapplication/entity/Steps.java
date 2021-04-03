package com.github.pawelsli.recipeswebapplication.entity;

import javax.persistence.*;

@Entity
public class Steps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipes_id")
    private Ingredients ingredients;

    private String description;
    private Long number;

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
