package com.goodiet.goodietbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.goodiet.goodietbackend.domain.Ingredient;
import com.goodiet.goodietbackend.domain.IngredientMeasure;
import com.goodiet.goodietbackend.domain.Recipe;

public interface IngredientMeasureRepository extends JpaRepository<IngredientMeasure, Long> {

	
	public IngredientMeasure findByIngredient(Ingredient ingrediente);
	
	public List<IngredientMeasure> findAllByIngredient(Ingredient ingrediente);
	
	public IngredientMeasure findByRecipe(Recipe receta);
	
	public List<IngredientMeasure> findAllByRecipe(Recipe receta);

}
