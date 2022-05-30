//package com.cg.nutritionapp.dao;
//
//import static org.junit.Assert.assertEquals;
//
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import com.cg.nutritionapp.NutritionAppApplication;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.cg.nutritionapp.model.NutritionPlan;
//import com.cg.nutritionapp.repository.NutritionPlanDAO;
//import com.cg.nutritionapp.repository.NutritionPlanDAOImpl;
//
//@SpringBootTest(classes = NutritionAppApplication.class)
//@RunWith(SpringRunner.class)
//public class NutritionPlanDAOImplTests {
//
//	@Autowired
//	private NutritionPlanDAO nutritionPlanDAO;
//
//	List<NutritionPlan> expectedNutritionPlanList;
//
//	NutritionPlan expectedNutritionPlan;
//
//	/**
//	 * Allocating objects after execution of every method
//	 *
//	 * @throws Exception
//	 */
//	@Before
//	public void setUp(){
//		System.out.println("Setting Up");
//		nutritionPlanDAO.deleteAll();
//		Date createdDate = new Date(System.currentTimeMillis());
//		Date updatedDate = new Date(System.currentTimeMillis());
//		expectedNutritionPlan=new NutritionPlan("Trial","This is a Trial Entry",createdDate,updatedDate,2000L);
//		expectedNutritionPlanList=new ArrayList<>();
//
//	}
//
//	//Testing Save() Method for NutritionPlanDAO
//	@Test
//	public void test_save(){
//		expectedNutritionPlanList.add(expectedNutritionPlan);
//		NutritionPlan actualNutritionPlan = nutritionPlanDAO.save(expectedNutritionPlan);
//		assertEquals(expectedNutritionPlan,actualNutritionPlan);
//	}
//
//	//Testing findAll() Method for NutritionPlanDAO
//	@Test
//	public void test_findAll(){
//		List<NutritionPlan> actualNutritionPlanList=nutritionPlanDAO.findAll();
//		assertEquals(expectedNutritionPlanList,actualNutritionPlanList);
//	}
//
//	//Testing for delete method of NutritionPlanDAO
//	@Test
//	public void test_delete(){
//		nutritionPlanDAO.save(expectedNutritionPlan);
//		nutritionPlanDAO.delete(expectedNutritionPlan);
//		assertEquals(Optional.empty(),nutritionPlanDAO.findById(expectedNutritionPlan.getId()));
//	}
//	/**
//	 * Deallocating objects after execution of every method
//	 *
//	 * @throws Exception
//	 */
//	@After
//	public void tearDown() throws Exception {
//		System.out.println("Tearing Down");
//		expectedNutritionPlan = null;
//		expectedNutritionPlanList = null;
//	}
//
//
//}
