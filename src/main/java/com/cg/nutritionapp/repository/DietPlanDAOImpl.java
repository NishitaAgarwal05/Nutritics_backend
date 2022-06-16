package com.cg.nutritionapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.nutritionapp.model.DietPlan;

@Repository
public abstract class DietPlanDAOImpl implements DietPlanDAO {
    private List<DietPlan> listOfPlans;

    @Autowired
    private DietPlanDAO dietPlanDAO;

    public DietPlanDAOImpl(){
        //listOfPlans = dietPlanDAO.findAll();
    }

    public DietPlan save(DietPlan dietPlan){
        listOfPlans.add(dietPlan);
        return dietPlan;
    }
    public void delete(DietPlan dietPlan){
        dietPlanDAO.delete(dietPlan);
    }
    public List<DietPlan> findAll(){
        //listOfPlans = dietPlanDAO.findAll();
        return dietPlanDAO.findAll();
    }
}
