package com.antra.phonepad.combination;

import com.antra.phonepad.combination.controller.Controller;
import com.antra.phonepad.combination.dto.request.NumberRequest;
import com.antra.phonepad.combination.service.GenerateWordService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


public class ControllerTest {

    public static ObjectMapper objectMapper;

    @Mock
    private GenerateWordService mockWordServices;

    @InjectMocks
    private Controller controller;

    private MockMvc mockMvc;

//    @BeforeAll
//    public static void setup(){
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//    }


//    @Test
//    public void testController() throws Exception {
//        List<String> wordList = new ArrayList<>();
//        wordList.add("tom");
//        String test = "";
//        when(mockWordServices.generate(test)).thenReturn(wordList);
//        List<String> combination = new ArrayList<>();
//        combination.add("tom add miss");
//        combination.add("tom add mips");
//        combination.add("tom add mirs");
//        combination.add("tom add nipp");
//        combination.add("tom add nipr");
//        combination.add("tom add nips");
//        when(mockWordServices.combine(wordList,wordList,wordList)).thenReturn(combination);
//        NumberRequest req = new NumberRequest();
//        req.setFirst("123");
//        req.setSecond("455");
//        req.setThird("5678");
//        this.mockMvc
//                .perform(post("/words")
//                        .param("number","2")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(req)))
//                        .andExpect(MockMvcResultMatchers.status().isOk())
//                        .andDo(MockMvcResultHandlers.print())
//                        .andReturn();
//    }


}
