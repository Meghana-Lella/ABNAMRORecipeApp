package com.cg.recipeApp.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.recipeApp.entity.Recipe;
import com.cg.recipeApp.recipedao.IRecipeDao;

@Service
public class recipeServiceimpl implements IrecipeService{
@Autowired
IRecipeDao iRecipeDao;

	@Override
	public String createRecipe(Recipe recipe) {
		 iRecipeDao.save(recipe);
		 return "Recipe added Sucessfully";
	}

	@Override
	public List<Recipe> getAllRecipes() {
		
		return iRecipeDao.findAll();
	}

	@Override
	public Recipe viewRecipesById(int id) throws NoSuchElementException {
		
		return iRecipeDao.findById(id).get();
	}

	@Override
	public String deleteById(int id) {	
		iRecipeDao.deleteById(id);
		return "Deleted Sucessfully";
	}

	@Override
	public Recipe updateRecipe(Recipe recipe,int id) {
		
		Recipe updatedRecipe =iRecipeDao.findById(id).get();
		updatedRecipe.setName(recipe.getName());
		updatedRecipe.setIngredients(recipe.getIngredients());
		updatedRecipe.setInstructions(recipe.getInstructions());
		updatedRecipe.setLocalDateandTime(recipe.getLocalDateandTime());
		updatedRecipe.setServings(recipe.getServings());
		updatedRecipe.setVeg(recipe.getVeg());
		return iRecipeDao.save(updatedRecipe);
		
	}

	
	
	
}
