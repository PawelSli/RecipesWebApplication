package com.github.pawelsli.recipeswebapplication.repository;

import com.github.pawelsli.recipeswebapplication.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {
    List<Recipe> findFirst10ByOrderByPublicationDateDesc();
    List<Recipe> findFirst10ByOrderByDifficultyDesc();
}
