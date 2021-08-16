package com.goodiet.goodietbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodiet.goodietbackend.domain.Measure;
import com.goodiet.goodietbackend.repository.MeasureRepository;
import com.goodiet.goodietbackend.utils.GoodietUtils;

@Service
public class MeasureService {
	
	@Autowired
	private MeasureRepository measureRepository;
	
	@Autowired
	private GoodietUtils goodietUtils;

	public List<Measure> findAll() {
		return measureRepository.findAll();
	}
	
	public Measure findById(Long id) {
		return measureRepository.findById(id).orElse(null);
	}
	
	public void saveMeasure(Measure medida) {
		if (goodietUtils.isValidMeasure(medida)) {
			measureRepository.save(medida);
		}
	}
}
