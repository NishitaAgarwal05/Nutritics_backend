package com.cg.nutritionapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nutritionapp.exceptions.PaymentException;
import com.cg.nutritionapp.model.Payment;
import com.cg.nutritionapp.service.PaymentService;

@RestController
@RequestMapping("api/v1")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

	@CrossOrigin(origins = {"https://nutritics-frontend.herokuapp.com","http://localhost:3000"})
	@GetMapping("/payment")
	ResponseEntity<List<Payment>> showAllPayments(){
		try{
			List<Payment> list = paymentService.showAllPayments();
			log.info("Payment List Displayed Successfully!!");
			return new ResponseEntity<>(list,HttpStatus.OK);
		}catch(PaymentException e) {
			log.error("Error Found :-->"+e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
	}
	@CrossOrigin(origins = {"https://nutritics-frontend.herokuapp.com","http://localhost:3000"})
	@GetMapping("/payment/{id}")
	ResponseEntity<Payment> getPaymentById(@PathVariable(value="id") Long id){
		try {
			Payment pay = paymentService.getPaymentById(id);
			log.info("Payment Displayed for "+id);
			return new ResponseEntity<>(pay,HttpStatus.OK);
		}catch(PaymentException e) {
			log.error("Error Found :-->"+e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = {"https://nutritics-frontend.herokuapp.com","http://localhost:3000"})
	@PostMapping("/payment/pay")
	public ResponseEntity<Payment> pay(@Valid @RequestBody Payment payment){
		try {
			Payment pay = paymentService.pay(payment);
			log.info("Payment Log Created Successfully !!");
			return new ResponseEntity<>(pay,HttpStatus.CREATED);
		}catch(PaymentException e) {
			log.error("Error Found :-->"+e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@CrossOrigin(origins = {"https://nutritics-frontend.herokuapp.com","https://localhost:3000"})
	@PutMapping("/payment")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment){
		try {
			Payment pay = paymentService.updatePayment(payment);
			log.info("Payment Updated Successfully !!");
			return new ResponseEntity<>(pay,HttpStatus.OK);
		}catch(PaymentException e) {
			log.error("Error Found :-->"+e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	// @CrossOrigin(origins = {"https://nutritics-frontend.herokuapp.com","http://localhost:3000"})
	// @PostMapping("/payment/addOffer")
	// public ResponseEntity<Void> addOffer(@RequestParam Double offerPrice){
	// 	try{
	// 		paymentService.addOffer(offerPrice);
	// 		log.info("Added Offer Successfully !!");
	// 		return new ResponseEntity<Void>(HttpStatus.OK);
	// 	}catch(PaymentException e) {
	// 		log.error("Error Found :-->"+e);
	// 		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	// 	}
	// }

}
