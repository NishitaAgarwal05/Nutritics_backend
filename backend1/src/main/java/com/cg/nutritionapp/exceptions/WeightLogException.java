package com.cg.nutritionapp.exceptions;


public class WeightLogException extends RuntimeException{
    public static final long serialVersionUID=1L;

    /**
     * Create NutritionPlanException object without error message
     */
    public WeightLogException()
    {
        super();
    }

    /**
     * Create NutritionPlanException object with error message
     * @param errMsg
     */

    public WeightLogException(String errMsg)
    {
        super(errMsg);
    }



}

