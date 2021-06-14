package com.github.pawelsli.recipeswebapplication.service.dto.builders;

import com.github.pawelsli.recipeswebapplication.service.dto.CompleteRecipeDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.IngredientDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.RecipeIngredientDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.StepDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CompleteRecipeDtoBuilder {
    public static CompleteRecipeDTO makeCompleteRecipeDTO(Long id,
                                                          Long userID,
                                                          String dishName,
                                                          String dishDesc,
                                                          Long preparationTimeQuantity,
                                                          String preparationTimeUnit,
                                                          Long numberOfPeople,
                                                          String difficulty,
                                                          List<StepDTO> steps,
                                                          List<IngredientDTO> ingredients,
                                                          List<RecipeIngredientDTO> recipeIngredientDTOS,
                                                          LocalDateTime publicationDate,
                                                          String image) {

        CompleteRecipeDTO completeRecipeDTO = new CompleteRecipeDTO();
        completeRecipeDTO.setId(id);
        completeRecipeDTO.setUserID(userID);
        completeRecipeDTO.setDishName(dishName);
        completeRecipeDTO.setDishDesc(dishDesc);
        completeRecipeDTO.setPreparationTimeQuantity(preparationTimeQuantity);
        completeRecipeDTO.setPreparationTimeUnit(preparationTimeUnit);
        completeRecipeDTO.setNumberOfPeople(numberOfPeople);
        completeRecipeDTO.setDifficulty(difficulty);
        completeRecipeDTO.setSteps(steps.stream().map(StepDTO::getDescription).collect(Collectors.toList()));
        completeRecipeDTO.setIngredients(ingredients.stream().map(IngredientDTO::getTitle).collect(Collectors.toList()));
        completeRecipeDTO.setIngredientsUnits(recipeIngredientDTOS.stream().
                map(e -> e.getIngredientUnit().name()).collect(Collectors.toList()));
        completeRecipeDTO.setIngredientsQuantities(recipeIngredientDTOS.stream().
                map(e -> e.getIngredientQuantity().toString()).collect(Collectors.toList()));
        completeRecipeDTO.setPublicationDate(publicationDate);
        completeRecipeDTO.setImage(image);


        return completeRecipeDTO;
    }
}
