package com.goodiet.goodietbackend.domain;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@SuppressWarnings("serial")

@Entity(name = "IngredientMeasure")
@Table(name = "ingredient_measure")
@Embeddable
public class IngredientMeasure implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "quantity")
	private int quantity;
	
	@ManyToOne
	private Measure measure;
	

	@ManyToOne
	private Ingredient ingredient;
	
	@ManyToOne()
	@JsonIgnore
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Recipe getRecipe() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	


}
