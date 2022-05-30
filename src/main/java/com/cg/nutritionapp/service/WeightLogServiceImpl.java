package com.cg.nutritionapp.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nutritionapp.controller.WeightLogController;
import com.cg.nutritionapp.exceptions.WeightLogException;
import com.cg.nutritionapp.model.WeightLog;
import com.cg.nutritionapp.repository.WeightLogDAO;

@Service
public class WeightLogServiceImpl implements WeightLogService{

	@Autowired
	private WeightLogDAO weightLogDAO;
	private static final Logger log = LoggerFactory.getLogger(WeightLogServiceImpl.class);

	public WeightLogServiceImpl() {

	}

	public boolean isValid(WeightLog weightLog){
		if(weightLog.getWeight()==null || weightLog.getCreatedAt()==null) {
			return false;
		} else if(weightLog.getWeight()>20 && weightLog.getWeight()<200){
			return true;
		} else { 
			return false;
		}
	}

	@Override
	public WeightLog addWeightLog(WeightLog weightLog) throws WeightLogException {

			if(isValid(weightLog)) {

				if(weightLog.getUpdatedAt().compareTo(weightLog.getCreatedAt())<0) {
					throw new WeightLogException("Updated Date should be after created date!");
				} else {
					log.info(weightLog.toString());
					WeightLog newWeightLog=weightLogDAO.save(weightLog);
					log.info(newWeightLog.toString());
					//newWeightLog.getUser().setU
					return newWeightLog;
				}
			} else {
				throw new WeightLogException("Invalid/empty fields");
			}


	}


	@Override
	public WeightLog updateWeightLog(Long id,WeightLog weightLog) throws WeightLogException{

			WeightLog existingWeightLog=weightLogDAO.findById(id).orElse(null);
			if(existingWeightLog!=null) {
				if(weightLog.getUpdatedAt().compareTo(weightLog.getCreatedAt())>=0) {
					weightLogDAO.save(weightLog);
					return weightLog;
				} else {
					throw new WeightLogException("Updated date should be after created date!");
				}
			} else {
				throw new WeightLogException("No matching weight log id");
			}

	}

	@Override
	public void removeWeightLog(Long id) throws WeightLogException{


			WeightLog existingWeightLog=weightLogDAO.findById(id).orElse(null);
			if(existingWeightLog!=null) {
				weightLogDAO.deleteById(id);
			} else {
				throw new WeightLogException("No matching weight log!");
			}

	}

	@Override
	public List<WeightLog> showAllWeightLog() {

		return weightLogDAO.findAll();

	}


	@Override
	public WeightLog findWeightLog(Long id) throws WeightLogException{
		WeightLog existingWeightLog=weightLogDAO.findById(id).orElse(null);
		if(existingWeightLog!=null) {
			return existingWeightLog;
		} else {
			throw new WeightLogException("No matching weight log!");
		}
	}
}

