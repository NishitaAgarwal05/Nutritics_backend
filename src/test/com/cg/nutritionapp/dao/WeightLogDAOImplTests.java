package com.cg.nutritionapp.dao;

import com.cg.nutritionapp.NutritionAppApplication;
import com.cg.nutritionapp.model.WeightLog;
import com.cg.nutritionapp.repository.WeightLogDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest(classes = NutritionAppApplication.class)
@RunWith(SpringRunner.class)
public class WeightLogDAOImplTests {

    @Autowired
    private WeightLogDAO weightLogDAO;
    List<WeightLog> expectedWeightLogList;
    WeightLog expectedWeight;


    /**
     * Set up the initial methods
     *
     * @throws Exception
     */
    @Before
    public void setUp(){
        System.out.println("Setting Up");
        weightLogDAO.deleteAll();
        LocalDate createdDate = LocalDate.now();
        LocalDate updatedDate = LocalDate.now();
        expectedWeight=new WeightLog(49.0,createdDate,updatedDate);
        expectedWeightLogList=new ArrayList<>();
    }
    //Testing Save() Method of WeightLogDAO
    @Test
    public void testSave(){

        expectedWeightLogList.add(expectedWeight);
        WeightLog actualWeight=weightLogDAO.save(expectedWeight);

        assertEquals(expectedWeight,actualWeight);
    }

    //Testing findAll() Method of WeightLogDAO
    @Test
    public void testFindAll(){

        List<WeightLog> actualWeightLogList=weightLogDAO.findAll();
       assertEquals(expectedWeightLogList,actualWeightLogList);
    }

    //Testing delete() method
    @Test
    public void testDelete(){

        weightLogDAO.save(expectedWeight);
        weightLogDAO.delete(expectedWeight);

        assertEquals(Optional.empty(),weightLogDAO.findById(expectedWeight.getId()));
    }
    /**
     * Deallocating objects after execution of every method
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing Down");
        expectedWeight=null;
        expectedWeightLogList=null;
    }

}
