package com.goodiet.goodietbackend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.goodiet.goodietbackend.domain.Recipe;
import com.goodiet.goodietbackend.repository.RecipeRepository;
import com.goodiet.goodietbackend.service.RecipeService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RequestMapping("/api/recipes")
@RestController


public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
    @GetMapping
    public List<Recipe> findAll(@RequestParam(required = false, name = "ingredient") String ingredient) {
        
    	if (ingredient!= null) {
    	
    	return recipeService.findAllByIngredients_ingredient_name(ingredient);
    		
    	} else {
    		
    	return recipeService.findAll();
    	
    	}
    }
        
    @GetMapping("/{id}")
    public Recipe findOne(@PathVariable Long id) {
        return recipeService.findById(id);
    }
    
    @PostMapping
    public Recipe create(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }
    
    @GetMapping("/buscar/{param}")
    public List<Recipe> findGlobal(@PathVariable String param) {
    	return recipeService.findGlobal(param);
    }
    
    @GetMapping("/buscar/category/{category}")
    public List<Recipe> findAllByCategory(@PathVariable String category) {
    	return recipeService.findAllByCategory(category);
    }
    
    @GetMapping("/buscar/ingredient/{ingredient}")
    public List<Recipe> findAllByIngredient(@PathVariable String ingredient) {
    	return recipeService.findAllByIngredient(ingredient);
    }

}
