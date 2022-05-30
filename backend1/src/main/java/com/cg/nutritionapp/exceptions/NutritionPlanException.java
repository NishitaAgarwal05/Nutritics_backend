package com.cg.nutritionapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NutritionPlanException extends RuntimeException{

	public NutritionPlanException()
	{
		super();
	}
	
	public NutritionPlanException(String errMsg)
	{
		super(errMsg);
	}

}