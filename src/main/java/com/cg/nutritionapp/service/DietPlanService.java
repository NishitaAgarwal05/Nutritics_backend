package com.cg.nutritionapp.service;

import java.util.List;
import java.util.Optional;

import com.cg.nutritionapp.model.DietPlan;
import com.cg.nutritionapp.exceptions.DietPlanException;

public interface DietPlanService {
    public DietPlan createDietPlan(DietPlan dietPlan) throws DietPlanException;
    public List<DietPlan> listAllPlans() throws DietPlanException;
    public void removeDietPlan(DietPlan dietPlan) throws DietPlanException;
    public DietPlan changeDietPlan(DietPlan dietPlan) throws DietPlanException;
}
