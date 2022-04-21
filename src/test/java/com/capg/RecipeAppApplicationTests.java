package com.capg;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.recipeApp.RecipeAppApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = RecipeAppApplication.class)
class RecipeAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
