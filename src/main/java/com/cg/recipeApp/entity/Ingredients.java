package com.cg.recipeApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="IngredientsList")
public class Ingredients {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String ingredients;

	
	public Ingredients(int id, String ingredients) {
		super();
		this.id = id;
		this.ingredients = ingredients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ingredients() {
		super();
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Ingredients [id=" + id + ", ingredients=" + ingredients + "]";
	}

	
}
