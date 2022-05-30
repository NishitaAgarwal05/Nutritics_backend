package com.cg.nutritionapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nutritionapp.exceptions.NutritionPlanException;
import com.cg.nutritionapp.model.NutritionPlan;
import com.cg.nutritionapp.repository.NutritionPlanDAO;

/**
 * This class provides the implementation of services
 *
 */

@Service
public class NutritionPlanServiceImpl implements NutritionPlanService{
	
	@Autowired
	private NutritionPlanDAO nutritionPlanDAO;
	
	@Override
	public NutritionPlan createPlan(NutritionPlan nutritionPlan)  {
		if(nutritionPlan.getName()== null || nutritionPlan.getPlanDescription() == null ||nutritionPlan.getCreated_At() == null ||nutritionPlan.getUpdated_At() == null || nutritionPlan.getPrice()== null  ) {
			throw new NutritionPlanException("Give all plan details for the plan to be created!!!!");
		}
		if(nutritionPlan.getCreated_At().compareTo(nutritionPlan.getUpdated_At())==0) {
			nutritionPlan = nutritionPlanDAO.save(nutritionPlan);
		}else {
			throw new NutritionPlanException("Created and Updated Date should be equal!!!!");
		}
		
		return nutritionPlan;
	}

	@Override
	public List<NutritionPlan> listAllPlans()  {
		return nutritionPlanDAO.findAll();
	}
	
	@Override
	public NutritionPlan getPlanWithId(Long id){
		NutritionPlan nutritionPlan = nutritionPlanDAO.findById(id).orElse(null);
		if(nutritionPlan == null) {
			throw new NutritionPlanException("This id doesn't exist!!!!");
		} 
		return nutritionPlan;
		
	}
	
	
	@Override
	public void removePlan(Long id)throws  NutritionPlanException {
		Optional<NutritionPlan> nutritionPlan = nutritionPlanDAO.findById(id);
		if(nutritionPlan == null) {
			throw new NutritionPlanException("This id doesn't exist!!!!");
		} 
		nutritionPlanDAO.deleteById(id);
	}
	
	@Override
	public NutritionPlan changePlan(Long id, NutritionPlan nutritionPlan){
		NutritionPlan existingPlan = nutritionPlanDAO.findById(id).orElse(null);
		if(existingPlan == null)
		{
			throw new NutritionPlanException("This id doesn't exist!!!!");
		} else if(nutritionPlan.getCreated_At().compareTo(nutritionPlan.getUpdated_At())<=0) {
			existingPlan.setName(nutritionPlan.getName());
			existingPlan.setPlanDescription(nutritionPlan.getPlanDescription());
			existingPlan.setCreated_At(nutritionPlan.getCreated_At());
			existingPlan.setUpdated_At(nutritionPlan.getUpdated_At());
			existingPlan.setPrice(nutritionPlan.getPrice());
			return nutritionPlanDAO.save(existingPlan);
		} else {
			throw new NutritionPlanException("Created Date should be before or same as Updated Date!!!!");

		}
		
		

	}
	
	

}
