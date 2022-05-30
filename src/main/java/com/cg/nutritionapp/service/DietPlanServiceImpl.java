package com.cg.nutritionapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nutritionapp.exceptions.DietPlanException;
import com.cg.nutritionapp.model.DietPlan;
import com.cg.nutritionapp.repository.DietPlanDAO;

@Service
public class DietPlanServiceImpl implements DietPlanService{

    @Autowired
    private DietPlanDAO dietPlanDAO;

    public boolean isValid(DietPlan dietPlan) {
//		if(dietPlan.getCarbsRatio() == null  || dietPlan.getFatRatio()==null|| dietPlan.getProteinRatio()==null|| dietPlan.getTotal()==null) {
//			return false;
//		}
//		else
//
        if(   dietPlan.getCarbsRatio()<0 || dietPlan.getCarbsRatio()>1
                || dietPlan.getFatRatio()<0 || dietPlan.getFatRatio()>1
                || dietPlan.getProteinRatio()<0 || dietPlan.getProteinRatio()>1
                || dietPlan.getTotal()<0 ) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public DietPlan createDietPlan(DietPlan dietPlan) throws  DietPlanException {

        if(isValid(dietPlan)) {
            if(dietPlan.getCarbsRatio() + dietPlan.getFatRatio() + dietPlan.getProteinRatio() == 1) {
                dietPlan = dietPlanDAO.save(dietPlan);
                return dietPlan;
            } else {
                throw new DietPlanException("Sum of Carbs Ratio, Fat Ratio and Protein Ratio should be exactly 1!");
            }

        } else {
            throw new DietPlanException("Invalid/empty fields entered!");
        }



//		dietPlan = dietPlanDAO.saveAndFlush(dietPlan);
//		return dietPlan;


    }

    @Override
    public List<DietPlan> listAllPlans() throws DietPlanException {
        return dietPlanDAO.findAll();
    }

    @Override
    public void removeDietPlan(DietPlan dietPlan) throws DietPlanException{
        try {
            DietPlan existingPlan = (dietPlanDAO.findById(dietPlan.getId())).orElse(null);
            if(existingPlan!=null) {
                dietPlanDAO.delete(dietPlan);
            } else {
                throw new DietPlanException("No such matching Diet Plan exists! ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public DietPlan changeDietPlan(DietPlan dietPlan) throws DietPlanException{
        DietPlan existingPlan = (dietPlanDAO.findById(dietPlan.getId())).orElse(null);
        if(existingPlan != null) {
            existingPlan.setSlots(dietPlan.getSlots());
            existingPlan.setFoodType(dietPlan.getFoodType());
            existingPlan.setProteinRatio(dietPlan.getProteinRatio());
            existingPlan.setFatRatio(dietPlan.getFatRatio());
            existingPlan.setCarbsRatio(dietPlan.getCarbsRatio());
            existingPlan.setTotal(dietPlan.getTotal());
//			existingPlan.setUserId(dietPlan.getUserId());
            return dietPlanDAO.save(existingPlan);
        } else {
            throw new DietPlanException("User Id not found");
        }

    }


}
