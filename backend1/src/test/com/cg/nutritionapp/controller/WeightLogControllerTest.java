//package com.cg.nutritionapp.controller;
//
//import com.cg.nutritionapp.model.WeightLog;
//import com.cg.nutritionapp.service.WeightLogService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.assertj.core.util.Arrays;
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(MockitoJUnitRunner.class)
//public class WeightLogControllerTest {
//
//    private MockMvc mockMvc;
//
//    ObjectMapper objectMapper =new ObjectMapper();
//
//    @Mock
//    private WeightLogService weightLogService;
//
//    //Class which is going to accept the mock
//    @InjectMocks
//    private WeightLogController weightLogController;
//
//    WeightLog weightLog1=new WeightLog(50.0, LocalDate.parse("2022-04-21"),LocalDate.parse("2022-04-21"));
//    WeightLog weightLog2=new WeightLog(65.0,LocalDate.parse("2022-04-21"),LocalDate.parse("2022-04-21"));
//    WeightLog weightLog3=new WeightLog(70.0,LocalDate.parse("2022-04-21"),LocalDate.parse("2022-04-21"));
//
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc= MockMvcBuilders.standaloneSetup(weightLogController).build();
//    }
//
//    @Test
//    public void testShowAllWeightLogs_Positive() throws Exception{
//        List<WeightLog> weightLogList=new ArrayList<>();
//        weightLogList.add(weightLog1);
//        weightLogList.add(weightLog2);
//        weightLogList.add(weightLog3);
//
//        Mockito.when(weightLogService.showAllWeightLog()).thenReturn(weightLogList);
//
//        MvcResult result=mockMvc.perform(MockMvcRequestBuilders
//                .get("/weightLog/showAllWeightLog")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//        System.out.println(result.getResponse());
//
//    }
//}
