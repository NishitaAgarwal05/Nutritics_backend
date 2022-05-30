package com.cg.nutritionapp.exceptions;

public class PaymentException extends RuntimeException{
	public PaymentException() {
		super();
	}
	public PaymentException(String msg) {
		super(msg);
	}
}
