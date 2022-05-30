package com.cg.nutritionapp.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.nutritionapp.model.NutritionPlan;

@Repository
public abstract class NutritionPlanDAOImpl implements NutritionPlanDAO {

}
