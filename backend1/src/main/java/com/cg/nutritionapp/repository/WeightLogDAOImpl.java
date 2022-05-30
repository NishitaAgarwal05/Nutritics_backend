package com.cg.nutritionapp.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.nutritionapp.model.WeightLog;

@Repository
public abstract class WeightLogDAOImpl implements WeightLogDAO {
	
	private List<WeightLog> weightLogList = new ArrayList<>();
	
	@Autowired
	private WeightLogDAO weightLogDAO;

	public WeightLogDAOImpl() {
		weightLogList=weightLogDAO.findAll();
	}



	@Override
	public WeightLog save(WeightLog weightLog) {
		weightLogList.add(weightLog);
		return weightLog;
	}

	/**
	 * This method is responsible for displaying the data to the user.
	 */
	@Override
	public List<WeightLog> findAll() {
		return  weightLogList;
	}

	/*
	 * User can Delete his/her weightLog here.
	 */
	@Override
	public void delete(WeightLog weightLog){
		weightLogDAO.deleteById(weightLog.getId());

	}
}

