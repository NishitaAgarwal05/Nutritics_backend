package com.cg.nutritionapp.repository;

import com.cg.nutritionapp.model.NutritionPlan;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface NutritionPlanDAO extends JpaRepository<NutritionPlan, Long> {
	public NutritionPlan save(NutritionPlan nutritionPlan);
    public void delete(NutritionPlan nutritionPlan);
    public List<NutritionPlan>findAll();
    public Optional<NutritionPlan> findById(Long id);
    public void deleteById(Long id);
}
