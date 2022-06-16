package com.cg.nutritionapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nutritionapp.exceptions.NutritionPlanException;
import com.cg.nutritionapp.model.NutritionPlan;
import com.cg.nutritionapp.service.NutritionPlanService;

/**
 * This class provides the controller for NutritionPlan module
 *
 */
@CrossOrigin(origins ={"https://nutritics-frontend.herokuapp.com","http://localhost:3000"})
@RestController
@RequestMapping("api/v1")
public class NutritionPlanController {
	
	@Autowired
	private NutritionPlanService nutritionPlanService;
	
	private static final Logger log = LoggerFactory.getLogger(NutritionPlanController.class);
	
    @GetMapping("/nutritionPlan/getAllPlans")
    ResponseEntity<List<NutritionPlan>> listAllPlans(){
    	List<NutritionPlan> listOfPlans = nutritionPlanService.listAllPlans();
    	 log.info("Nutrition Plan list displayed successfully!");
            return new ResponseEntity<>(listOfPlans, HttpStatus.OK);
//    	 return listOfPlans;
    }
    @GetMapping("/nutritionPlan/getPlan/{id}")
    ResponseEntity<NutritionPlan> getPlan(@PathVariable Long id){
    	 try{
         	NutritionPlan plan = nutritionPlanService.getPlanWithId(id);
         	 log.info("Nutrition Plan with id = " + id + " displayed successfully!");
         	return new ResponseEntity<>(plan,HttpStatus.OK);	
         }catch(NutritionPlanException e) {
         	log.error("Error Found:-->"+e);
         	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
         }
    }


    @PostMapping("/nutritionPlan/createPlan")
    public ResponseEntity<NutritionPlan> createPlan( @RequestBody NutritionPlan nutritionPlan){
            try{
            	NutritionPlan plan = nutritionPlanService.createPlan(nutritionPlan);
            	 log.info("Nutrition Plan Successfully Created!");
                return new ResponseEntity<>(plan, HttpStatus.CREATED);
            }catch(NutritionPlanException e) {
            	 log.error("Error Found:-->"+e);
            	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
            }
            
    }
    
    @PutMapping("/nutritionPlan/changePlan/{id}")
    public ResponseEntity<NutritionPlan> changePlan(@PathVariable Long id,@RequestBody NutritionPlan nutritionPlan){
            try{
            	NutritionPlan plan = nutritionPlanService.changePlan(id,nutritionPlan);
            	 log.info("Nutrition Plan updated successfully!");
            	return new ResponseEntity<>(plan,HttpStatus.OK);	
            }catch(NutritionPlanException e) {
            	log.error("Error Found:-->"+e);
            	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
            }
            	
    }
    
    @DeleteMapping("/nutritionPlan/removePlan/{id}")
    public ResponseEntity<Void> removePlan(@PathVariable Long id){
            try{
                nutritionPlanService.removePlan(id);
                log.info("Nutrition Plan deleted successfully!");
                return new ResponseEntity<Void>(HttpStatus.OK);
            }catch(NutritionPlanException e) {
            	log.error("Error Found:-->"+e);
            	return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }
            
}

}
