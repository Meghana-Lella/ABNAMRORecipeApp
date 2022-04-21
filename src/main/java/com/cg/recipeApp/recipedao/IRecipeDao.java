package com.cg.recipeApp.recipedao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.recipeApp.entity.Recipe;

public interface IRecipeDao extends JpaRepository<Recipe, Integer>{

	

}
