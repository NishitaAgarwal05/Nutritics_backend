package com.cg.nutritionapp.exceptions;

//UserException Class
public class UserExceptions extends RuntimeException{

	public UserExceptions()
	{
		super();
	}
	
	public UserExceptions(String errMsg)
	{
		super(errMsg);
	}

}