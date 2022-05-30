package com.cg.nutritionapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.nutritionapp.model.Payment;

@Repository
public abstract class PaymentDAOImpl implements PaymentDAO{
	
	private List<Payment> paymentList = new ArrayList<>();
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	
	
	@Override
	public Payment save(Payment payment) {
		paymentList.add(payment);
		return payment;
	}
	
	/**
	 * This method is responsible for displaying the data to the user.
	 */
	@Override
	public List<Payment> findAll(){
		return paymentList;
	}
	
	@Override
	public Payment getById(Long id) {
		Payment pay = null;
		for(Payment p : paymentList) {
			if(p.getId() == id) {
				pay = p;
			}
		}
		return pay;
	}
	
	/**
	 * User can Delete his/her Payment here.
	 */
	@Override
	public void delete(Payment payment) {
		paymentDAO.delete(payment);
	}
}
