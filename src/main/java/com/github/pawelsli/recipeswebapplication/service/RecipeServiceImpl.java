package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.*;
import com.github.pawelsli.recipeswebapplication.repository.*;
import com.github.pawelsli.recipeswebapplication.service.dto.*;
import com.github.pawelsli.recipeswebapplication.service.dto.builders.CompleteRecipeDtoBuilder;
import org.javatuples.Quartet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private StepRepository stepRepository;
    private RecipeRepository recipeRepository;
    private UserRepository userRepository;
    private IngredientRepository ingredientRepository;
    private RecipeIngredientRepository recipeIngredientRepository;
    private final static Logger log = LoggerFactory.getLogger(RecipeServiceImpl.class);
    private final Path root = Paths.get("src/main/recipe-application-frontend/public/");

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
    public MainPageDTO getMainPageDishes() {
        return new MainPageDTO(getRandomRecipes(),getMostPopularRecipes(),getNewestRecipes());
    }

    @Override
    public DifficultyAndUnitsDTO getDifficultyAndUnits() {

        List<RecipeDifficulty> recipeDifficultyList = Arrays.asList(RecipeDifficulty.values());
        List<IngredientUnit> ingredientUnitList = Arrays.asList(IngredientUnit.values());
        DifficultyAndUnitsDTO difficultyAndUnitsDTO = new DifficultyAndUnitsDTO(ingredientUnitList, recipeDifficultyList);

        return difficultyAndUnitsDTO;
    }

    @Override
    public List<CompleteRecipeDTO> searchRecipes(String query) {
        String[] words = query.strip().split(" ");
        List<String> stringList= Arrays.stream(words).map(e -> "%"+e+"%").collect(Collectors.toList());
        stringList.forEach(System.out::println);

        List<Recipe> recipeList = recipeRepository.findAll(RecipeRepository.multiLikeColumn(stringList));
        List<Ingredient> ingredientList = ingredientRepository.findAll(IngredientRepository.multiLikeColumn(stringList));
        if(ingredientList.isEmpty()) System.out.println("Something is not yes");
        List<Recipe> recipesByIngredients = ingredientList.stream().map(this::findRecipeByIngredient).collect(Collectors.toList());
        if(recipesByIngredients.isEmpty()) System.out.println("Something is not yes");

        List<Recipe> finalList = new ArrayList<>(recipeList);
        finalList.addAll(recipesByIngredients.stream().filter(e -> !recipeList.contains(e)).collect(Collectors.toList()));
        if(finalList.isEmpty()) System.out.println("Something is not yes");


        return finalList.stream().map(this::prepareRecipeDTO).collect(Collectors.toList());
    }

    @Override
    public Void addRecipe(MultipartFile file, CompleteRecipeDTO completeRecipeDTO) {

        Quartet<RecipeDTO, List<StepDTO>, List<IngredientDTO>, List<RecipeIngredientDTO>> recipeDTO = completeRecipeDTO.convertToRecipeDTO();
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
    public List<CompleteRecipeDTO> getNewestRecipes() {
        List<Recipe> recipeList = recipeRepository.findTop9ByOrderByPublicationDateDesc();

        return recipeList.stream().map(this::prepareRecipeDTO).collect(Collectors.toList());

    }

    @Override
    public List<CompleteRecipeDTO> getMostPopularRecipes() {
        List<Recipe> recipeList = recipeRepository.findTop9ByOrderByLikesDesc();

        return recipeList.stream().map(this::prepareRecipeDTO).collect(Collectors.toList());
    }

    @Override
    public List<CompleteRecipeDTO> getRandomRecipes() {
        List<Recipe> recipeList = recipeRepository.findRandomRecipes();

        return recipeList.stream().map(this::prepareRecipeDTO).collect(Collectors.toList());
    }

    @Override
    public List<CompleteRecipeDTO> getUserRecipes(User user){
        List<Recipe> recipeList = recipeRepository.findAllByUser(user);

        return recipeList.stream().map(this::prepareRecipeDTO).collect(Collectors.toList());
    }

    @Override
    public CompleteRecipeDTO findRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow();

        return prepareRecipeDTO(recipe);
    }

    private CompleteRecipeDTO prepareRecipeDTO(Recipe recipe){
        List<IngredientDTO> ingredientDTOList = recipe.getRecipeIngredientSet().
                stream().map(e -> new IngredientDTO(e.getIngredient())).collect(Collectors.toList());

        return CompleteRecipeDtoBuilder.makeCompleteRecipeDTO(
                recipe.getId(),
                recipe.getUser().getId(),
                recipe.getTitle(),
                recipe.getDescription(),
                recipe.getPreparationTime(),
                recipe.getTimeUnit(),
                recipe.getPeopleNumber(),
                recipe.getDifficulty().toString(),
                recipe.getSteps().stream().map(StepDTO::new).collect(Collectors.toList()),
                ingredientDTOList,
                recipe.getRecipeIngredientSet().stream().map(RecipeIngredientDTO::new).collect(Collectors.toList()),
                recipe.getPublicationDate(),
                recipe.getImage());

    }

    public Recipe findRecipeByIngredient(Ingredient ingredient){
        return ingredient.getRecipeIngredientSet().get(0).getRecipe();
    }


}
