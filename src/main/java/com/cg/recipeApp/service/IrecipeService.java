package com.cg.recipeApp.service;

import java.util.List;

import com.cg.recipeApp.entity.Recipe;

public interface IrecipeService {

	String createRecipe(Recipe recipe);
	Recipe updateRecipe(Recipe recipe,int id);
	List<Recipe> getAllRecipes();
	Recipe viewRecipesById(int id);
	String deleteById(int id);
	
}
