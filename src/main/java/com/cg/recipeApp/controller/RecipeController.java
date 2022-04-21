package com.cg.recipeApp.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.recipeApp.entity.Recipe;
import com.cg.recipeApp.exception.RecipeNotFoundException;
import com.cg.recipeApp.service.IrecipeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/recipe")

public class RecipeController {
	@Autowired
	IrecipeService irecipeService;
	
	@PostMapping("/addRecipe")
	public ResponseEntity<String> addProperty(@RequestBody Recipe recipe) {
		
		return new ResponseEntity<String>( irecipeService.createRecipe(recipe),HttpStatus.OK);
		
	}
	
	@GetMapping("/viewAllRecipes")
	public ResponseEntity<List<Recipe>> viewAllRecips(){
	 
		return new ResponseEntity<List<Recipe>>(irecipeService.getAllRecipes(),HttpStatus.OK);
	
	}
	
	@GetMapping("/viewRecipeById/{id}")
	public ResponseEntity<Recipe> findById(@PathVariable int id) throws Exception{
		try 
		{
			return new  ResponseEntity<Recipe>(irecipeService.viewRecipesById(id),HttpStatus.OK);
		}
		catch(NoSuchElementException e) 
		{
			throw new Exception("No Recipes are found");
		}
	}
	
	@DeleteMapping("/deleteRecipeById/{id}")
	public String deleteById(@PathVariable int id) throws Exception{
		try
		{
			irecipeService.deleteById(id);
			return "Recipe deleted Successfully";
		}
		catch(Exception e)
		{
			throw new Exception("No id is found");
		}
	}
	
	@PutMapping(value="/updateRecipe/{id}")
	public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe,@PathVariable int id) throws Exception {
		
		try 
		{
			return new ResponseEntity<Recipe>( irecipeService.updateRecipe(recipe,id),HttpStatus.OK);
		}
		catch(Exception e) 
		{
			throw new Exception("We can't edit Recipe");
		}
	}
	
}
