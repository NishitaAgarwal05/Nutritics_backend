package com.cg.nutritionapp.service;

import java.util.List;
import java.util.Optional;

import com.cg.nutritionapp.exceptions.NutritionPlanException;
import com.cg.nutritionapp.model.NutritionPlan;

/**
 * This interface is used for providing services
 *
 */
public interface NutritionPlanService {
	public NutritionPlan createPlan(NutritionPlan nutritionPlan);
	public List<NutritionPlan> listAllPlans() ;
	public void removePlan(Long id);
	public NutritionPlan changePlan(Long id, NutritionPlan nutritionPlan);
	public NutritionPlan getPlanWithId(Long id);

}
