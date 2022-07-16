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

import com.cg.nutritionapp.exceptions.DietPlanException;
import com.cg.nutritionapp.model.DietPlan;
import com.cg.nutritionapp.service.DietPlanService;

@CrossOrigin(origins = {"https://nutritics-frontend.herokuapp.com","http://localhost:3000"})
@RestController
@RequestMapping("api/v1")
public class DietPlanController {

    @Autowired
    private DietPlanService dietPlanService;

    private static final Logger log = LoggerFactory.getLogger(DietPlanController.class);

//	@GetMapping("/test")
//    ResponseEntity<String> getOk(){
//            return new ResponseEntity<>("OK", HttpStatus.ACCEPTED);
//    }

    @GetMapping("/dietPlan/listAllPlans")
    ResponseEntity<List<DietPlan>> listAllPlans(){
        try {
            List<DietPlan> listOfDietPlans =  dietPlanService.listAllPlans();
            log.info("List of Diet Plans is displayed successfully!");
            return new ResponseEntity<>(listOfDietPlans, HttpStatus.OK);
        } catch(DietPlanException e) {
            log.error("Error Found:-->"+ e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/dietPlan/getPlan/{id}")
    ResponseEntity<DietPlan> getPlan(@PathVariable Long id){
    	 try{
         	DietPlan plan =dietPlanService.getPlanWithId(id);
         	 log.info("Diet Plan with id = " + id + " displayed successfully!");
         	return new ResponseEntity<>(plan,HttpStatus.OK);	
         }catch(DietPlanException e) {
         	log.error("Error Found:-->"+e);
         	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
         }
    }


    @PostMapping("/dietPlan/createDietPlan")
    public ResponseEntity<DietPlan> createDietPlan(@RequestBody DietPlan dietPlan){
        try {
            DietPlan plan = dietPlanService.createDietPlan(dietPlan);
            log.info("Diet Plan created Successfully!");
            return new ResponseEntity<>(plan, HttpStatus.CREATED);
        } catch (DietPlanException e) {
            log.error("Error Found:-->"+e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @PutMapping("/dietPlan/changeDietPlan/{id}")
    public ResponseEntity<DietPlan> changeDietPlan(@PathVariable Long id, @RequestBody DietPlan dietPlan){

        try{
            DietPlan plan = dietPlanService.changeDietPlan(dietPlan);
            log.info("Diet Plan Updated Successfully!");
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } catch(DietPlanException e) {
            log.error("Error Found:-->"+ e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @DeleteMapping("/dietPlan/removeDietPlan/{id}")
    public ResponseEntity<Void> removeDietPlan(@PathVariable Long id, @RequestBody DietPlan dietPlan){

        try {
            dietPlanService.removeDietPlan(dietPlan);
            log.info("Diet Plan deleted successfully!");
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (DietPlanException e) {
            log.error("Error Found:-->"+e);
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

    }

}
