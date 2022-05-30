package com.cg.nutritionapp.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cg.nutritionapp.NutritionAppApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.nutritionapp.model.Payment;
import com.cg.nutritionapp.repository.PaymentDAO;

@SpringBootTest(classes = NutritionAppApplication.class)
@RunWith(SpringRunner.class)
public class PaymentDAOImplTests {
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	List<Payment> expectedPaymentList;
	
	Payment expectedPayment;
	
	/**
	 * Allocating objects after execution of every method
	 *
	 * @throws Exception
	 */
//	@Before
//	public void setUp() {
//		System.out.println("Setting Up");
//		LocalDate createdDate = LocalDate.now();
//		LocalDate updatedDate = LocalDate.now();
//		expectedPayment = new Payment(20000.0,4000.0,createdDate,updatedDate,"U1",1);
//		expectedPaymentList = new ArrayList<>();
//	}
	
	//Testing Save() Method for PaymentDAO
		@Test
		public void test_save(){
			expectedPaymentList.add(expectedPayment);
			Payment actualPayment = paymentDAO.save(expectedPayment);
			assertEquals(expectedPayment,actualPayment);
		}

		//Testing findAll() Method for PaymentDAO
//		@Test
//		public void test_findAll(){
//			List<Payment> actualPaymentList=paymentDAO.findAll();
//			assertEquals(expectedPaymentList,actualPaymentList);
//		}

		//Testing for delete method of PaymentDAO
		@Test
		public void test_delete(){
			paymentDAO.save(expectedPayment);
			paymentDAO.delete(expectedPayment);
			assertEquals(Optional.empty(),paymentDAO.findById(expectedPayment.getId()));
		}
		/**
		 * Deallocating objects after execution of every method
		 *
		 * @throws Exception
		 */
		@After
		public void tearDown() throws Exception {
			System.out.println("Tearing Down");
			expectedPayment = null;
			expectedPaymentList = null;
		}

}
