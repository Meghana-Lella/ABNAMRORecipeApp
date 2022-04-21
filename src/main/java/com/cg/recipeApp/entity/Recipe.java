package com.cg.recipeApp.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="Recipe100")
public class Recipe {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="recipe_id")
	 private int id;

	    private String name;
	    @JsonFormat(pattern="dd‐MM‐yyyy HH:mm", shape=Shape.STRING)
		private LocalDateTime localDateandTime;
	    private boolean veg;
	    private int servings;
	    
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "recipe_id")
	    private List<Ingredients> ingredients;
	    private String instructions;
	    
	    
		public Recipe() {
			super();
		}


		public Recipe(int id, String name, LocalDateTime localDateandTime, boolean veg, int servings,
				List<Ingredients> ingredients, String instructions) {
			super();
			this.id = id;
			this.name = name;
			this.localDateandTime = localDateandTime;
			this.veg = veg;
			this.servings = servings;
			this.ingredients = ingredients;
			this.instructions = instructions;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public LocalDateTime getLocalDateandTime() {
			return localDateandTime;
		}


		public void setLocalDateandTime(LocalDateTime localDateandTime) {
			this.localDateandTime = localDateandTime;
		}


		public boolean getVeg() {
			return veg;
		}


		public void setVeg(boolean veg) {
			this.veg = veg;
		}


		public int getServings() {
			return servings;
		}


		public void setServings(int servings) {
			this.servings = servings;
		}


		public List<Ingredients> getIngredients() {
			return ingredients;
		}


		public void setIngredients(List<Ingredients> ingredients) {
			this.ingredients = ingredients;
		}


		public String getInstructions() {
			return instructions;
		}


		public void setInstructions(String instructions) {
			this.instructions = instructions;
		}


		@Override
		public String toString() {
			return "Recipe [id=" + id + ", name=" + name + ", localDateandTime=" + localDateandTime + ", veg=" + veg
					+ ", servings=" + servings + ", ingredients=" + ingredients + ", instructions=" + instructions
					+ "]";
		}


	
		
}
