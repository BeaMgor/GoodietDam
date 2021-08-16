package com.goodiet.goodietbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodiet.goodietbackend.domain.Category;
import com.goodiet.goodietbackend.repository.CategoryRepository;
import com.goodiet.goodietbackend.utils.GoodietUtils;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private GoodietUtils goodietUtils;
	
	/**
	 * Devuelve todas las categorías
	 * 
	 * @return
	 */
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	/**
	 * Devuelve la categoría cuyo id es el pasado como parámetro
	 * @param id
	 * @return
	 */
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	/**
	 * Devuelve la categoría cuyo nombre es el pasado como parámetro
	 * @param id
	 * @return
	 */
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}
	
	/**
	 * Creación y guardado de Category
	 * 
	 * @param category
	 */
	public void saveCategory(Category category) {
		if (goodietUtils.isValidCategory(category)) {
			categoryRepository.save(category);
		}
	}

}
