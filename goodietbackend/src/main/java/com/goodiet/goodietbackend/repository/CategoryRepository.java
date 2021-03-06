package com.goodiet.goodietbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodiet.goodietbackend.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Category findByName(String name);
}
