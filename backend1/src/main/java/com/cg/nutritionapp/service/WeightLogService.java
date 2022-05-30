package com.cg.nutritionapp.service;

import java.util.List;

import com.cg.nutritionapp.exceptions.WeightLogException;
import com.cg.nutritionapp.model.WeightLog;

public interface WeightLogService {

	public WeightLog addWeightLog(WeightLog weightLog) throws WeightLogException;
	public WeightLog updateWeightLog(Long id,WeightLog weightLog) throws WeightLogException;
	public void removeWeightLog(Long id) throws WeightLogException;
	public List<WeightLog> showAllWeightLog();
	public WeightLog findWeightLog(Long id);

}