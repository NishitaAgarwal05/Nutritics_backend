package com.cg.nutritionapp.service;

import com.cg.nutritionapp.NutritionAppApplication;
import com.cg.nutritionapp.exceptions.DietPlanException;
import com.cg.nutritionapp.model.DietPlan;
import com.cg.nutritionapp.repository.DietPlanDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.*;

@SpringBootTest(classes = NutritionAppApplication.class)
@RunWith(SpringRunner.class)
public class DietPlanServiceTests {
    @Autowired
    private DietPlanService dietPlanService;

    @Autowired
    private DietPlanDAO dietPlanDAO;

    List<DietPlan> expectedDietPlanList;

    DietPlan expectedDietPlan;

    @Before
    public void setUp(){
        System.out.println("Setting Up");
        dietPlanDAO.deleteAll();
        expectedDietPlan=new DietPlan("TestSlot","TestFoodType", 0.2D, 0.3D, 0.5D,1200D);
        expectedDietPlanList=new ArrayList<>();
    }
    //Testing createDietPlan() Method for NutritionPlanService
    @Test
    public void test_CreatePlan() throws DietPlanException {
        DietPlan actualDietPlan = dietPlanService.createDietPlan(expectedDietPlan);
        assertEquals(expectedDietPlan,actualDietPlan);
    }

    //Testing listAllPlans() Method for DietPlanService
    @Test
    public void test_listAll(){
        DietPlan plan1 =new DietPlan("TestSlot-1","TestFoodType-1", 0.2D, 0.3D, 0.5D,1200D);
        DietPlan plan2 =new DietPlan("TestSlot-2","TestFoodType-2", 0.6D, 0.1D, 0.3D,1600D);
        expectedDietPlanList.add(plan1);
        expectedDietPlanList.add(plan2);
        dietPlanService.createDietPlan(plan1);
        dietPlanService.createDietPlan(plan2);
        List<DietPlan> actualDietPlanList=dietPlanService.listAllPlans();
        assertEquals(expectedDietPlanList.size(),actualDietPlanList.size());
    }

    //Testing removeDietPlan() Method for DietPlanService
    @Test
    public void test_removeDietPlan()throws DietPlanException {
        dietPlanService.createDietPlan(expectedDietPlan);
        dietPlanService.removeDietPlan(expectedDietPlan);
        assertEquals(true,dietPlanService.listAllPlans().isEmpty());
    }

    @Test
    public void test_changeDietPlan()throws DietPlanException {
        dietPlanService.createDietPlan(expectedDietPlan);
        expectedDietPlan.setTotal(4000D);
        DietPlan actualDietPlan =  dietPlanService.changeDietPlan(expectedDietPlan);
        assertThat(actualDietPlan, samePropertyValuesAs(expectedDietPlan));
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing Down");
        expectedDietPlan = null;
        expectedDietPlanList = null;
    }
}
