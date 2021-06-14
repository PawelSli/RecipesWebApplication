package com.github.pawelsli.recipeswebapplication.service.dto;

import com.github.pawelsli.recipeswebapplication.entity.Recipe;
import com.github.pawelsli.recipeswebapplication.entity.RecipeDifficulty;
import java.time.LocalDateTime;
import java.util.List;

public class RecipeDTO {

    private long id;
    private List<Long> stepsIds;
    private Long userId;
    private String title;
    private String description;
    private Long preparationTime;
    private String timeUnit;
    private LocalDateTime publicationDate;
    private RecipeDifficulty difficulty;
    private Long peopleNum;
    private String imageName;
    private Long likes;
    private Long dislikes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Long> getStepsIds() {
        return stepsIds;
    }

    public void setStepsIds(List<Long> stepsIds) {
        this.stepsIds = stepsIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Long preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public RecipeDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(RecipeDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Long getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Long peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    public Recipe convertToRecipe(){
        Recipe recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setDescription(description);
        recipe.setPreparationTime(preparationTime);
        recipe.setTimeUnit(timeUnit);
        recipe.setPublicationDate(publicationDate);
        recipe.setDifficulty(difficulty);
        recipe.setPeopleNumber(peopleNum);
        recipe.setImage(imageName);
        recipe.setLikes(0L);
        recipe.setDislikes(0L);

        return recipe;
    }
}
