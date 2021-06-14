package com.github.pawelsli.recipeswebapplication.service.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pawelsli.recipeswebapplication.entity.IngredientUnit;
import com.github.pawelsli.recipeswebapplication.entity.RecipeDifficulty;
import org.javatuples.Quartet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CompleteRecipeDTO {
    private Long id;
    private Long userID;
    private String dishName;
    private String dishDesc;
    private Long preparationTimeQuantity;
    private String preparationTimeUnit;
    private Long numberOfPeople;
    private String difficulty;
    private List<String> steps;
    private List<String> ingredients;
    private List<String> ingredientsUnits;
    private List<String> ingredientsQuantities;
    @JsonIgnore
    private LocalDateTime publicationDate;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDesc() {
        return dishDesc;
    }

    public void setDishDesc(String dishDesc) {
        this.dishDesc = dishDesc;
    }

    public Long getPreparationTimeQuantity() {
        return preparationTimeQuantity;
    }

    public void setPreparationTimeQuantity(Long preparationTimeQuantity) {
        this.preparationTimeQuantity = preparationTimeQuantity;
    }

    public String getPreparationTimeUnit() {
        return preparationTimeUnit;
    }

    public void setPreparationTimeUnit(String preparationTimeUnit) {
        this.preparationTimeUnit = preparationTimeUnit;
    }

    public Long getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Long numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredientsUnits() {
        return ingredientsUnits;
    }

    public void setIngredientsUnits(List<String> ingredientsUnits) {
        this.ingredientsUnits = ingredientsUnits;
    }

    public List<String> getIngredientsQuantities() {
        return ingredientsQuantities;
    }

    public void setIngredientsQuantities(List<String> ingredientsQuantities) {
        this.ingredientsQuantities = ingredientsQuantities;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }


    public Quartet<RecipeDTO, List<StepDTO>, List<IngredientDTO>, List<RecipeIngredientDTO>> convertToRecipeDTO() {

        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setUserId(userID);
        recipeDTO.setTitle(dishName);
        recipeDTO.setDescription(dishDesc);
        recipeDTO.setPreparationTime(preparationTimeQuantity);
        recipeDTO.setTimeUnit(preparationTimeUnit);
        recipeDTO.setPublicationDate(LocalDateTime.now());
        recipeDTO.setDifficulty(RecipeDifficulty.valueOf(difficulty));
        recipeDTO.setPeopleNum(numberOfPeople);

        AtomicInteger atomicInteger = new AtomicInteger();

        atomicInteger.set(0);
        List<StepDTO> stepDTOList = new ArrayList<>();
        steps.forEach(e -> {
            if (atomicInteger.get() != 0) {
                StepDTO stepDTO = new StepDTO();
                stepDTO.setDescription(e);
                stepDTO.setNumber((long) atomicInteger.get());
                stepDTOList.add(stepDTO);
            }
            atomicInteger.getAndIncrement();
        });

        atomicInteger.set(0);
        List<IngredientDTO> ingredientDTOList = new ArrayList<>();
        List<RecipeIngredientDTO> recipeIngredientDTOS = new ArrayList<>();
        ingredients.forEach(e -> {
            System.out.println(e);
            if (atomicInteger.get() != 0) {
                IngredientDTO ingredientDTO = new IngredientDTO();
                ingredientDTO.setTitle(e);
                ingredientDTOList.add(ingredientDTO);
                RecipeIngredientDTO recipeIngredientDTO = new RecipeIngredientDTO();
                recipeIngredientDTO.setIngredientQuantity(Double.parseDouble(ingredientsQuantities.get(atomicInteger.get())));
                System.out.println(ingredientsUnits.get(atomicInteger.get()));
                recipeIngredientDTO.setIngredientUnit(IngredientUnit.valueOf(ingredientsUnits.get(atomicInteger.get())));
                recipeIngredientDTOS.add(recipeIngredientDTO);
            }
            atomicInteger.incrementAndGet();
        });
        atomicInteger.set(0);
        return Quartet.with(recipeDTO, stepDTOList, ingredientDTOList, recipeIngredientDTOS);
    }
}
