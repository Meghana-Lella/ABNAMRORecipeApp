package com.cg.recipeApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.recipeApp.recipedao.IRecipeDao;

@SpringBootApplication
public class RecipeAppApplication {

	public static void main(String[] args) {
		//SpringApplication.run(RecipeAppApplication.class, args);
		ConfigurableApplicationContext applicationContext = SpringApplication.run(RecipeAppApplication.class,
				args);
		IRecipeDao recipeRepository = applicationContext.getBean(IRecipeDao.class);
	}
	

}
