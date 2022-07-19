package com.cg.nutritionapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nutritionapp.exceptions.PaymentException;
import com.cg.nutritionapp.model.Payment;
import com.cg.nutritionapp.repository.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	@Override
	public Payment pay(Payment payment){
		// TODO Auto-generated method stub
		if(payment.getPayment()==null || /*payment.getDiscount()==null ||*/ payment.getCreated_At()==null || payment.getUpdated_At()==null || payment.getUser()==null) {
			throw new PaymentException("Give all Details for model to be created");
		}
		if(payment.getCreated_At().compareTo(payment.getUpdated_At())==0) {
			payment = paymentDAO.save(payment);
		}else {
			throw new PaymentException("Created and Updated Date should be equal!!!!");
		}
		return payment;
	}

	@Override
	public List<Payment> showAllPayments(){
		// TODO Auto-generated method stub
		return paymentDAO.findAll();
	}
	
	@Override
	public Payment getPaymentById(Long id) {
		Payment existingPay = paymentDAO.findById(id).orElse(null);
		if(existingPay == null)
		{
			throw new PaymentException("User Id not Found");
		}else {
			return paymentDAO.getById(id);
		}

	}

	// @Override
	// public void addOffer(double offerPrice) {
	// 	// TODO Auto-generated method stub
	// 	List<Payment> allPayments = paymentDAO.findAll();
	// 	for(Payment payment : allPayments) {
	// 		if(payment.getPayment()< offerPrice) {
	// 			throw new PaymentException("Offer Price cannot be greater than Original Price for id: "+payment.getId());
	// 		}
	// 		payment.setPayment(payment.getPayment()-offerPrice);
	// 		paymentDAO.save(payment);
	// 	}
		
		
	// }

	@Override
	public Payment updatePayment(Payment payment){
		// TODO Auto-generated method stub
		if(payment.getId()==null || payment.getPayment()==null || /*payment.getDiscount()==null ||*/ payment.getCreated_At()==null || payment.getUpdated_At()==null || payment.getUser()==null) {
			throw new PaymentException("Give all Details for model to be Updated !!");
		}
		Payment existingPay = paymentDAO.findById(payment.getId()).orElse(null);
		if(existingPay == null)
		{
			throw new PaymentException("User Id not Found");
		}else if (payment.getCreated_At().compareTo(payment.getUpdated_At()) <= 0) {
			existingPay.setPayment(payment.getPayment());
			// existingPay.setDiscount(payment.getDiscount());
			existingPay.setCreated_At(payment.getCreated_At());
			existingPay.setUpdated_At(payment.getUpdated_At());
			existingPay.setUser(payment.getUser());
			existingPay.setPlanId(payment.getPlanId());
			return paymentDAO.save(existingPay);
		}else {
			throw new PaymentException("Updated Date should be after or same as Created Date!!");
		}
		
	}

}
