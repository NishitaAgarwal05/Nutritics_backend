package com.cg.nutritionapp.dao;

import static org.junit.Assert.assertEquals;


import java.sql.Date;
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

import com.cg.nutritionapp.model.DietPlan;
import com.cg.nutritionapp.repository.DietPlanDAO;
import com.cg.nutritionapp.repository.DietPlanDAOImpl;

@SpringBootTest(classes = NutritionAppApplication.class)
@RunWith(SpringRunner.class)
public class DietPlanDAOImplTests {

    @Autowired
    private DietPlanDAO dietPlanDAO;

    List<DietPlan> expectedDietPlanList;

    DietPlan expectedDietPlan;

    /**
     * Allocating objects after execution of every method
     *
     * @throws Exception
     */
    @Before
    public void setUp(){
        System.out.println("Setting Up");
        dietPlanDAO.deleteAll();

        expectedDietPlan=new DietPlan("TestSlot","TestFoodType", 0.2D, 0.3D, 0.5D,1200D);
        expectedDietPlanList=new ArrayList<>();

    }

    //Testing Save() Method for DietPlanDAO
    @Test
    public void test_save(){
        expectedDietPlanList.add(expectedDietPlan);
        DietPlan actualDietPlan = dietPlanDAO.save(expectedDietPlan);
        assertEquals(expectedDietPlan,actualDietPlan);
    }

    //Testing findAll() Method for DietPlanDAO
    @Test
    public void test_findAll(){
        List<DietPlan> actualDietPlanList=dietPlanDAO.findAll();
        assertEquals(expectedDietPlanList,actualDietPlanList);
    }

    //Testing for delete method of NutritionPlanDAO
    @Test
    public void test_delete(){
        dietPlanDAO.save(expectedDietPlan);
        dietPlanDAO.delete(expectedDietPlan);
        assertEquals(Optional.empty(),dietPlanDAO.findById(expectedDietPlan.getId()));
    }
    /**
     * Deallocating objects after execution of every method
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing Down");
        expectedDietPlan = null;
        expectedDietPlanList = null;
    }


}
