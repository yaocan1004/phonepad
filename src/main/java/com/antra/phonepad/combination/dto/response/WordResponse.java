package com.antra.phonepad.combination.dto.response;

import java.util.*;

public class WordResponse {
    private String phoneNumber;
    private List<String> wordCombination;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getWordCombination() {
        return wordCombination;
    }

    public void setWordCombination(List<String> wordCombination) {
        this.wordCombination = wordCombination;
    }
}
