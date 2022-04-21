package com.capg;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.recipeApp.entity.Ingredients;
import com.cg.recipeApp.entity.Recipe;
import com.cg.recipeApp.recipedao.IRecipeDao;
import com.cg.recipeApp.service.IrecipeService;
@SpringBootTest
public class RecipesTest extends RecipeAppApplicationTests {
	
	@MockBean
	IRecipeDao irecipesDao;
	
	@Autowired
	private IrecipeService irecipesService;
	
	private Recipe testGetRecipes() {
		
		Ingredients ingredients = new Ingredients();
		ingredients.setIngredients("spicy");
		Ingredients ingredient1 = new Ingredients();
		ingredient1.setIngredients("salt");
		List<Ingredients> list = List.of(ingredients,ingredient1);
		
		Recipe recipes = new Recipe();
		recipes.setId(1);
		recipes.setName("egg noodles");
		recipes.setLocalDateandTime(LocalDateTime.now());
		recipes.setVeg(false);
		recipes.setServings(3);
		recipes.setIngredients(list);
		recipes.setInstructions("recipe for 4 members");
		return recipes;
		
	}
	

    @Test
	void testCreateRecipes() throws Exception
    {
		Recipe recipe = testGetRecipes();
		when(irecipesDao.save(recipe)).thenReturn(recipe);
		assertNotNull(recipe);
	
	}
    @Test
    void testGetRecipe() throws Exception
    {
     Recipe recipe = testGetRecipes();
     int Id = 1;

      when(irecipesDao.findById(1)).thenReturn(Optional.of(recipe));
      assertEquals(recipe,irecipesService.viewRecipesById(recipe.getId()));
    }
	@Test
	void testUpdateRecipe() throws Exception {
		Recipe recipes = testGetRecipes();
		recipes.setName("Chilli panir tikka");
		recipes.setInstructions("ABC");
		when(irecipesDao.findById(recipes.getId())).thenReturn(Optional.of(recipes));
		
		when(irecipesDao.save(recipes)).thenReturn(recipes);
		assertThat(irecipesService.updateRecipe(recipes,1)).isEqualTo(recipes);
	}
	
	@Test
	void testDeleteRecipe() throws Exception{
		Recipe recipes = testGetRecipes();
	    when(irecipesDao.findById(9)).thenReturn(Optional.of(recipes));
	    irecipesService.deleteById(9);
	    verify(irecipesDao,times(1)).deleteById(9);
	}
	
	
	
}
