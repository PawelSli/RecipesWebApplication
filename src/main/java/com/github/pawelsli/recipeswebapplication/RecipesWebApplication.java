package com.github.pawelsli.recipeswebapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class RecipesWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesWebApplication.class, args);
	}



}
