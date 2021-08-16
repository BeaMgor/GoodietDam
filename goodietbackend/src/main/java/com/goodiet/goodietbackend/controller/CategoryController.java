package com.goodiet.goodietbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodiet.goodietbackend.domain.Category;
import com.goodiet.goodietbackend.service.CategoryService;

@RequestMapping("/api/categories")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }
        
    @GetMapping("/{id}")
    public Category findOne(@PathVariable Long id) {
        return categoryService.findById(id);
    }
    
    @PostMapping
    public void create(@RequestBody Category category) {
    	categoryService.saveCategory(category);
    }
    
    
	
}
