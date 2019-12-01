package com.antra.phonepad.combination.service;
import java.io.IOException;
import java.util.*;

public interface GenerateWordService {

    List<String> generate(String num);
    List<String> combine(List<String> first, List<String> second, List<String> third);
}
