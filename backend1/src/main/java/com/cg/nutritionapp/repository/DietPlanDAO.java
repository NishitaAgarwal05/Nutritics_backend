package com.cg.nutritionapp.repository;
import com.cg.nutritionapp.model.DietPlan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DietPlanDAO extends JpaRepository<DietPlan, Long>{

    /**
     * this save method is used for inserting records into table dietPlan
     */
    public DietPlan save(DietPlan dietPlan);


    /**
     * this update method is used for updating records into table products
     */
    public List<DietPlan> findAll();

    /**
     * this delete method is used for deleting records by id from table dietPlan
     */
    public void delete(DietPlan dietPlan);


}
