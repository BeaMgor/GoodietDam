package com.goodiet.goodietbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodiet.goodietbackend.domain.Measure;

public interface MeasureRepository extends JpaRepository<Measure, Long> {

}
