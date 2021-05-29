package com.github.pawelsli.recipeswebapplication;

import com.github.pawelsli.recipeswebapplication.service.RecipeServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;


@SpringBootApplication
@EnableSwagger2
public class RecipesWebApplication {
	@Resource
	RecipeServiceImpl recipeService;

	public static void main(String[] args) {
		SpringApplication.run(RecipesWebApplication.class, args);
	}


}
