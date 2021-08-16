package com.goodiet.goodietbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodiet.goodietbackend.domain.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	
	public Ingredient findByName(String name);

}
