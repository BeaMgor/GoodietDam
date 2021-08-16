package com.goodiet.goodietbackend.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.goodiet.goodietbackend.domain.Category;
import com.goodiet.goodietbackend.domain.Ingredient;
import com.goodiet.goodietbackend.domain.IngredientMeasure;
import com.goodiet.goodietbackend.domain.Recipe;
import com.goodiet.goodietbackend.repository.RecipeRepository;
import com.goodiet.goodietbackend.utils.GoodietUtils;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private GoodietUtils goodietUtils;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private IngredientMeasureService ingredientMeasureService;
	
	/**
	 * Devuelve todas las recetas
	 * 
	 * @return
	 */
	public List<Recipe> findAll() {
		return recipeRepository.findAll();
	}
	
	/**
	 * Devuelve la receta cuyo id es el pasado como parámetro
	 * @param id
	 * @return
	 */
	public Recipe findById(Long id) {
		return recipeRepository.findById(id).orElse(null);
	}
	
	/**
	 * Creación y guardado de Recipe
	 * 
	 * @param recipe
	 */
	public Recipe saveRecipe(Recipe recipe) {
		if (goodietUtils.isValidRecipe(recipe)) {
			recipeRepository.save(recipe);
			List<IngredientMeasure> ingredients = recipe.getIngredients();
			for (IngredientMeasure ingredientMeasure : ingredients) {
				ingredientMeasureService.saveIngredientMeasure(ingredientMeasure);
			}
		}
		
		return recipe;
	}
	
	/**
	 * Devuelve el listado de recetas pertenecientes a la categoría pasada como parámetro
	 * 
	 * @param categoria
	 * @return
	 */
	public List<Recipe> findAllByCategory(String name) {
		Category categoria = categoryService.findByName(name);
		return recipeRepository.findAllByCategory(categoria);
	}
	
	/**
	 * Devuelve la lista de recetas con el nombre especificado
	 * 
	 * @param nombre
	 * @return
	 */
	public List<Recipe> findAllByName(String nombre) {
		return recipeRepository.findAllByName(nombre);
	}
	
	/**
	 * Devuelve la receta con el nombre especificado
	 * 
	 * @param nombre
	 * @return
	 */
	public Recipe findByName(String nombre) {
		return recipeRepository.findByName(nombre);
	}
		
	/**
	 * Devuelve el listado de recetas que contengan el ingrediente pasado como parámetro
	 * @param ingrediente
	 * @return
	 */
	public List<Recipe> findAllByIngredient(String nombreIngrediente) {
		Ingredient ingrediente = ingredientService.findByName(nombreIngrediente);
		List<IngredientMeasure> ingredientRecipe = ingredientMeasureService.findAllByIngredient(ingrediente);
		List<Recipe> listaRecetas = new ArrayList<>();
		ingredientRecipe.forEach(x -> {
			Recipe receta = x.getRecipe();
			listaRecetas.add(receta);
		});
		
		return listaRecetas;
	}
	
	public List<Recipe> findAllByIngredients_ingredient_name(String ingredient) {
		return recipeRepository.findAllByIngredients_ingredient_name(ingredient);
	}
	
	/**
	 * Devuelve un listado de recetas buscando por ingrediente, nombre o categoría
	 * 
	 * @param param
	 * @return
	 */
	public List<Recipe> findGlobal(String param) {
		List<Recipe> result = new ArrayList<>();
		
		if (findAllByIngredient(param) != null) {
			result = findAllByIngredient(param);
		} else if (findAllByCategory(param) != null) {
			result = findAllByCategory(param);
		} else if (findAllByName(param) != null) {
			result = findAllByName(param);
		}
		
		return result;
	}

}
