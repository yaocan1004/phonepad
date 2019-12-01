package com.antra.phonepad.combination;

import com.antra.phonepad.combination.service.GenerateWordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceTest {

    @Autowired
    GenerateWordService wordServices;

    @Test
    public void testService(){
        //4 digits num could generate 36 different combinations
        int combonation = 81;
        List<String> res = wordServices.generate("2356");
        System.out.println(res.size());
        assertTrue(res.size() < combonation);
    }
}
