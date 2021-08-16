package com.goodiet.goodietbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodiet.goodietbackend.domain.Ingredient;
import com.goodiet.goodietbackend.service.IngredientService;

@RequestMapping("/api/ingredients")
@RestController
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;
	
    @GetMapping
    public List<Ingredient> findAll() {
        return ingredientService.findAll();
    }
        
    @GetMapping("/{id}")
    public Ingredient findOne(@PathVariable Long id) {
        return ingredientService.findById(id);
    }
    
    @PostMapping
    public void create(@RequestBody Ingredient ingrediente) {
    	ingredientService.saveIngredient(ingrediente);
    }
    
    
	
}
