package com.cg.nutritionapp.controller;

import java.util.List;

import com.cg.nutritionapp.exceptions.WeightLogException;
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

import com.cg.nutritionapp.model.WeightLog;
import com.cg.nutritionapp.service.WeightLogService;

@CrossOrigin(origins ={"https://nutritics-frontend.herokuapp.com","http://localhost:3000"})
@RestController
@RequestMapping("/api/v1")
public class WeightLogController {

	@Autowired
	private WeightLogService weightLogService;

	private static final Logger log = LoggerFactory.getLogger(WeightLogController.class);

	@PostMapping("/weightLog/addWeightLog")
	public ResponseEntity<WeightLog> addWeightLog(@RequestBody WeightLog weightLog){
		log.info(weightLog.toString());
		try {
			WeightLog newWeightLog = weightLogService.addWeightLog(weightLog);
			log.info("Weight Log Successfully Created!");
			return new ResponseEntity<>(newWeightLog, HttpStatus.CREATED);
		} catch(WeightLogException e){
			log.error("Error Found:-->"+e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/weightLog/showWeightLog/{id}")
	public ResponseEntity<List<WeightLog>> findWeightLogById(@PathVariable("id") Long id) {
		try {
			List<WeightLog> weightLogList= weightLogService.findWeightLog(id);
		return new ResponseEntity<>(weightLogList, HttpStatus.CREATED);
		} catch(WeightLogException e) {
			log.error("Error Found:-->"+e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/weightLog/showAllWeightLog")
	public ResponseEntity<List<WeightLog>> showAllWeightLog(){
		try {
			List<WeightLog> weightLogList = weightLogService.showAllWeightLog();
			log.info("Weight Log list displayed successfully!");
			return new ResponseEntity<>(weightLogList, HttpStatus.OK);
		} catch(WeightLogException e){
			log.error("Error Found:-->"+e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/weightLog/updateWeightLog/{id}")
	public ResponseEntity<WeightLog> updateWeightLog(@PathVariable("id") Long id,@RequestBody WeightLog weightLog) {
		try {
			weightLogService.updateWeightLog(id,weightLog);
			log.info("Weight Log updated successfully!");
			return new ResponseEntity<>(weightLog, HttpStatus.OK);
		} catch(WeightLogException e){
			log.error("Error Found:-->"+e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/weightLog/removeWeightLog/{id}")
	public ResponseEntity<Void> removeWeightLog(@PathVariable("id") Long id){
		try {
			weightLogService.removeWeightLog(id);
			log.info("Weight Log deleted successfully!");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(WeightLogException e){
			log.error("Error Found:-->"+e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
