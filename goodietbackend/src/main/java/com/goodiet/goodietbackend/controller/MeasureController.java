package com.goodiet.goodietbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodiet.goodietbackend.domain.Measure;
import com.goodiet.goodietbackend.service.MeasureService;

@RequestMapping("/api/measures")
@RestController
public class MeasureController {

	@Autowired
	private MeasureService measureService;
	
    @GetMapping
    public List<Measure> findAll() {
        return measureService.findAll();
    }
        
    @GetMapping("/{id}")
    public Measure findOne(@PathVariable Long id) {
        return measureService.findById(id);
    }
    
    @PostMapping
    public void create(@RequestBody Measure medida) {
    	measureService.saveMeasure(medida);
    }
    
    
	
}
