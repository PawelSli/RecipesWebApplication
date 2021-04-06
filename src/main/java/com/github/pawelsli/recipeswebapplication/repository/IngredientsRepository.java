package com.github.pawelsli.recipeswebapplication.repository;

import com.github.pawelsli.recipeswebapplication.entity.Ingredients;
import com.github.pawelsli.recipeswebapplication.entity.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients,Integer> {
}
