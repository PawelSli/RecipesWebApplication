package com.github.pawelsli.recipeswebapplication.entity;

import javax.persistence.*;

@Entity
public class Steps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable=false,unique=true)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id",referencedColumnName="id",nullable=false,unique=true)
    private Recipes recipe;

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
