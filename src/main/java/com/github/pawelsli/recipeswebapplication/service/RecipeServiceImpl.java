package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.*;
import com.github.pawelsli.recipeswebapplication.repository.*;
import com.github.pawelsli.recipeswebapplication.service.dto.*;
import org.javatuples.Quartet;
import org.javatuples.Triplet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private StepRepository stepRepository;
    private RecipeRepository recipeRepository;
    private UserRepository userRepository;
    private IngredientRepository ingredientRepository;
    private RecipeIngredientRepository recipeIngredientRepository;
    private final static Logger log = LoggerFactory.getLogger(RecipeServiceImpl.class);
    private final Path root = Paths.get("src/main/resources/static/images/");

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository,
                             UserRepository userRepository,
                             IngredientRepository ingredientRepository,
                             RecipeIngredientRepository recipeIngredientRepository,
                             StepRepository stepRepository){
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.stepRepository = stepRepository;
    }

    @Override
    public DifficultyAndUnitsDTO getDifficultyAndUnits() {

        List<RecipeDifficulty> recipeDifficultyList = Arrays.asList(RecipeDifficulty.values());
        List<IngredientUnit> ingredientUnitList = Arrays.asList(IngredientUnit.values());
        DifficultyAndUnitsDTO difficultyAndUnitsDTO = new DifficultyAndUnitsDTO(ingredientUnitList, recipeDifficultyList);

        return difficultyAndUnitsDTO;
    }

    @Override
    public Void addRecipe(MultipartFile file, AddRecipeDTO addRecipeDTO) {

        Quartet<RecipeDTO, List<StepDTO>, List<IngredientDTO>, List<RecipeIngredientDTO>> recipeDTO = addRecipeDTO.convertToRecipeDTO();
        Recipe recipe = recipeDTO.getValue0().convertToRecipe();
        Optional<User> user = userRepository.findById(recipeDTO.getValue0().getUserId());
        recipe.setUser(user.orElseThrow());
        recipe.setImage(file.getOriginalFilename());
        List<Ingredient> ingredientList = recipeDTO.getValue2().stream().map(IngredientDTO::convertToIngredient).collect(Collectors.toList());
        List<RecipeIngredient> recipeIngredientList = recipeDTO.getValue3().stream().map(RecipeIngredientDTO::convertToRecipeIngredient).collect(Collectors.toList());
        List<Step> stepList = recipeDTO.getValue1().stream().map(StepDTO::convertToStep).collect(Collectors.toList());

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(0);
        recipe.setRecipeIngredientSet(recipeIngredientList);
        recipe.setSteps(stepList);
        ingredientList.forEach(e -> {
            e.setRecipeIngredientSet(recipeIngredientList);
            recipeIngredientList.get(atomicInteger.get()).setIngredient(e);
            recipeIngredientList.get(atomicInteger.getAndIncrement()).setRecipe(recipe);
        });
        stepList.forEach(e -> e.setRecipe(recipe));

        recipeRepository.save(recipe);
        ingredientRepository.saveAll(ingredientList);
        recipeIngredientRepository.saveAll(recipeIngredientList);
        stepRepository.saveAll(stepList);



        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not store the file.");
        }

        return null;
    }

    @Override
    public List<RecipeDTO> getRecipes() {
        return null;
    }

    @Override
    public List<RecipeDTO> getNewestRecipes() {
        return null;
    }

    @Override
    public List<RecipeDTO> getMostPopularRecipes() {
        return null;
    }

    @Override
    public RecipeDTO findRecipeById(Long id) {
        return null;
    }

    @Override
    public MainPageDTO getMainPageDishes() {
        return null;
    }
}
