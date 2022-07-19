package com.cg.nutritionapp.service;

import java.util.List;

import com.cg.nutritionapp.exceptions.PaymentException;
import com.cg.nutritionapp.model.Payment;

public interface PaymentService {
	public Payment pay(Payment payment);
	public List<Payment> showAllPayments();
	// public void addOffer(double offerPrice)throws PaymentException;
	// public Payment updatePayment(Payment payment)throws PaymentException;
	public Payment getPaymentById(Long id) ;

}
