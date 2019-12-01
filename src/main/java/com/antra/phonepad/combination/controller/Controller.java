package com.antra.phonepad.combination.controller;


import com.antra.phonepad.combination.dto.request.NumberRequest;
import com.antra.phonepad.combination.dto.response.WordResponse;
import com.antra.phonepad.combination.service.GenerateWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    GenerateWordService services;

    @PostMapping("/words")
    public WordResponse getWordCombination(@Valid @RequestBody NumberRequest req, @RequestParam("number") int number)throws IOException {
        List<String> firstMap = services.generate(req.getFirst());
        List<String> secondMap = services.generate(req.getSecond());
        List<String> thirdMap = services.generate(req.getThird());
        List<String> combinations = services.combine(firstMap, secondMap, thirdMap);
        if(combinations.size() > number){
            List<String> limitedComb = new ArrayList<>();
            for(int i = 0; i < number; i++){
                limitedComb.add(combinations.get(i));
            }
            combinations = limitedComb;
        }
        WordResponse response = new WordResponse();
        response.setWordCombination(combinations);
        response.setPhoneNumber(req.toString());
        return response;
    }



}
