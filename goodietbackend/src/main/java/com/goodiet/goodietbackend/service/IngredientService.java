package com.goodiet.goodietbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodiet.goodietbackend.domain.Ingredient;
import com.goodiet.goodietbackend.repository.IngredientRepository;
import com.goodiet.goodietbackend.utils.GoodietUtils;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private GoodietUtils goodietUtils;
	
	public Ingredient findById(Long id) {
		return ingredientRepository.findById(id).orElse(null);
	}
	
	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}
	
	public Ingredient findByName(String name) {
		return ingredientRepository.findByName(name);
	}
	
	/**
	 * Creación y guardado de Category
	 * 
	 * @param category
	 */
	public void saveIngredient(Ingredient ingrediente) {
		if (goodietUtils.isValidIngredient(ingrediente)) {
			ingredientRepository.save(ingrediente);
		}
	}
	
}
