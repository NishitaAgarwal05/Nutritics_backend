package com.cg.nutritionapp.service;

import com.cg.nutritionapp.NutritionAppApplication;
import com.cg.nutritionapp.exceptions.WeightLogException;
import com.cg.nutritionapp.model.WeightLog;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = NutritionAppApplication.class)
@RunWith(SpringRunner.class)
public class WeightLogServiceImplTests {

    @Autowired
    private WeightLogServiceImpl weightLogServiceImpl;

    WeightLog expectedWeight;
    List<WeightLog> expectedWeightLogList;


    /**
     * Set up the initial methods
     *
     * @throws Exception
     */
    @BeforeEach
    public void setUp(){
        System.out.println("Setting Up");
        expectedWeightLogList=new ArrayList<>();
    }

    //Positive Test case to Test isValid() method
    @Test
    public void testIsValid_Positive(){
        expectedWeight=new WeightLog(49.0,LocalDate.parse("2022-04-21"),LocalDate.parse("2022-04-21"));
        Assertions.assertTrue(weightLogServiceImpl.isValid(expectedWeight));
    }

    //Negative Test case to Test isValid() method
    @Test
    @DisplayName("Testing by giving invalid weight")
    public void testIsValid_Negative(){
        expectedWeight=new WeightLog(0.0,LocalDate.parse("2022-04-21"),LocalDate.parse("2022-04-21"));
        Assertions.assertFalse(weightLogServiceImpl.isValid(expectedWeight));
    }

    /* Negative Test case to test addWeightLog() method
        Invalid/Empty weightlog object given
     */
    @Test
    public void testAddWeightLog_Negative_InvalidField(){

        try{
            expectedWeight=new WeightLog(0.0,LocalDate.parse("2022-04-21"),LocalDate.parse("2022-04-21"));
            weightLogServiceImpl.addWeightLog(expectedWeight);
        } catch (WeightLogException e){
            Assertions.assertEquals("Invalid/empty fields",e.getMessage());
        }
    }

    /* Negative Test case to test addWeightLog() method
        Created Date and Updated date of weightlog object is not matching when adding a new log.
     */
    @Test
    public void testAddWeightLog_Negative_DateMismatch(){

        try{
            expectedWeight=new WeightLog(50.0,LocalDate.parse("2022-04-21"),LocalDate.parse("2022-04-25"));
            weightLogServiceImpl.addWeightLog(expectedWeight);
        } catch (WeightLogException e){
            Assertions.assertEquals("Created and Updated Date should be same!",e.getMessage());
        }
    }

    /* Positive Test case to test addWeightLog() method

     */
    @Test
    public void testAddWeightLog_Positive(){

        try{
            expectedWeight=new WeightLog(50.0,LocalDate.parse("2022-04-21"),LocalDate.parse("2022-04-21"));
           WeightLog actualWeight=weightLogServiceImpl.addWeightLog(expectedWeight);
           expectedWeightLogList.add(expectedWeight);

            Assertions.assertEquals(expectedWeight,actualWeight);
        } catch (WeightLogException e){
            Assertions.fail("Exception");
        }
    }

    /* Positive Test case to test updateWeightLog() method

     */
//    @Test
//    public void testUpdateWeightLog_Positive(){
//        try {
//            expectedWeight = new WeightLog( 50.0, LocalDate.parse("2022-04-21"), LocalDate.parse("2022-04-21"));
//            weightLogServiceImpl.addWeightLog(expectedWeight);
//            expectedWeightLogList.add(expectedWeight);
//
//            expectedWeight.setWeight(70.0);
//            WeightLog actualWeight = weightLogServiceImpl.updateWeightLog(expectedWeight);
//
//            Assertions.assertEquals(expectedWeight, actualWeight);
//        } catch (WeightLogException e){
//            Assertions.fail(e.getMessage());
//        }
//    }


    /* Negative Test case to test updateWeightLog() method
       Updated date is given before created date.
    */
//    @Test
//    public void testUpdateWeightLog_Negative_DateMismatch(){
//
//        try{
//            expectedWeight = new WeightLog( 50.0, LocalDate.parse("2022-04-21"), LocalDate.parse("2022-04-21"));
//            weightLogServiceImpl.addWeightLog(expectedWeight);
//
//            expectedWeight.setUpdatedAt( LocalDate.parse("2022-04-19"));
//            weightLogServiceImpl.updateWeightLog(expectedWeight);
//        } catch (WeightLogException e){
//            Assertions.assertEquals("Updated date should be after created date!",e.getMessage());
//        }
//    }

    /* Positive Test case for removeWeightLog() method

     */
//    @Test
//    public void testRemoveWeightLog_Positive(){
//        expectedWeight = new WeightLog( 50.0, LocalDate.parse("2022-04-21"), LocalDate.parse("2022-04-21"));
//        weightLogServiceImpl.addWeightLog(expectedWeight);
//        int originalSize=weightLogServiceImpl.showAllWeightLog().size();
//
//        weightLogServiceImpl.removeWeightLog(expectedWeight);
//
//        Assertions.assertEquals(originalSize-1,weightLogServiceImpl.showAllWeightLog().size());
//    }

    /* Negative Test Case for removeWeightLog() method

     */
//    @Test
//    public void testRemoveWeightLog_Negative(){
//        try {
//            expectedWeight = new WeightLog( );
//            expectedWeight.setId(12L);
//            expectedWeight.setWeight(65.0);
//            expectedWeight.setCreatedAt(LocalDate.parse("2022-04-21"));
//            expectedWeight.setUpdatedAt(LocalDate.parse("2022-04-21"));
//            weightLogServiceImpl.removeWeightLog(expectedWeight);
//        } catch (WeightLogException e){
//            Assertions.assertEquals("No matching weight log!",e.getMessage());
//        }
//    }

    /* Test case for showAllWeightLog() method

     */
//    @Test
//    public void testShowAllWeightLog(){
//        List<WeightLog> actualWeightLogList=weightLogServiceImpl.showAllWeightLog();
//        Assertions.assertEquals(expectedWeightLogList,actualWeightLogList);
//    }
    /**
     * Deallocating objects after execution of every method
     *
     * @throws Exception
     */
    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Tearing Down");
        expectedWeight=null;
        expectedWeightLogList=null;
    }
}
