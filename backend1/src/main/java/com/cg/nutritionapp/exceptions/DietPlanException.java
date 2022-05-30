package com.cg.nutritionapp.exceptions;

public class DietPlanException extends RuntimeException{
    public DietPlanException() {
        super();
    }

    public DietPlanException (String errMsg) {
        super(errMsg);
    }
}
