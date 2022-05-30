package com.cg.nutritionapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.nutritionapp.model.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Long>{
	
	
	Payment save(Payment payment);
	
	List<Payment> findAll();
	
	//The method was provided in DAO layer but not present in the Service Layer
	void delete(Payment payment);
	
	Payment getById(Long id);
	
}
