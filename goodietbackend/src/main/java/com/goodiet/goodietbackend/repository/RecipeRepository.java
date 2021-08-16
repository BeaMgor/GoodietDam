package com.goodiet.goodietbackend.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.goodiet.goodietbackend.domain.Category;
import com.goodiet.goodietbackend.domain.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	
	public Recipe findByName(String nombre);
	
	public List<Recipe> findAllByName(String nombre);
	
	public List<Recipe> findAllByCategory(Category categoria);
			
	@Query(value = "SELECT * FROM db.recipe WHERE db.recipe.ingredients.ingredient.name LIKE :ingredient", nativeQuery = true)
	public List<Recipe> findAllByIngredients_ingredient_name(@Param("ingredient") String ingredient);
	
	 

}
