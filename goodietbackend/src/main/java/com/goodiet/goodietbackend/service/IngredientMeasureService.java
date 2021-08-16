package com.goodiet.goodietbackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.goodiet.goodietbackend.domain.Ingredient;
import com.goodiet.goodietbackend.domain.IngredientMeasure;
import com.goodiet.goodietbackend.repository.IngredientMeasureRepository;

@Service
public class IngredientMeasureService {
	
	@Autowired
	private IngredientMeasureRepository ingredientMeasureRepository;

	public IngredientMeasure findByIngredient(Ingredient ingrediente) {
		return ingredientMeasureRepository.findByIngredient(ingrediente);
	}
	
	public List<IngredientMeasure> findAllByIngredient(Ingredient ingrediente) {
		return ingredientMeasureRepository.findAllByIngredient(ingrediente);
	}
	
	public void saveIngredientMeasure(IngredientMeasure ingredientMeasure) {
		ingredientMeasureRepository.save(ingredientMeasure);
	}
}