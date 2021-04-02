package com.github.pawelsli.recipeswebapplication.repository;

import com.github.pawelsli.recipeswebapplication.entity.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipes,Integer> {
    List<Recipes> findFirst10ByOrderByPublicationDateDesc();
    List<Recipes> findFirst10ByOrderByDifficultyDesc();
}
