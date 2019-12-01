package com.antra.phonepad.combination.service;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenerateWordServiceImp implements GenerateWordService {
    Map<Character,String[]> map = new HashMap<Character,String[]>() {{
        put('0',new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"});
        put('1',new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"});
        put('2',new String[]{"a","b","c"});
        put('3',new String[]{"d","e","f"});
        put('4',new String[]{"g","h","i"});
        put('5',new String[]{"j","k","l"});
        put('6',new String[]{"m","n","o"});
        put('7',new String[]{"p","q","r","s"});
        put('8',new String[]{"t","u","v"});
        put('9',new String[]{"w","x","y","z"});
    }};
    Map<String, List<String>> cache = new HashMap<>();

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<String> generate(String digits){
        if(cache.containsKey(digits)) return cache.get(digits);
        List<String> ans = new ArrayList<>();
        if(digits.length() != 0){
            backtrack("",digits, ans);
        }
        cache.put(digits,new ArrayList<>(ans));
        return ans;
    }

    private void backtrack(String cob, String next_digits, List<String> ans){
        if(next_digits.length() == 0){
            if(validation(cob))
                ans.add(cob);
        }else{
            char cur_dig = next_digits.charAt(0);
            for(String str: map.get(cur_dig)){
                backtrack(cob+str, next_digits.substring(1),ans);
            }
        }
    }


    private boolean validation(String word){
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.add("x-rapidapi-host", "wordsapiv1.p.rapidapi.com");
            headers.add("x-rapidapi-key", "a41a35e2b0msh1e1c56482658460p120f19jsnbf6bc72252a5");
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    "https://wordsapiv1.p.rapidapi.com/words/{word}/typeOf",
                    HttpMethod.GET,
                    new HttpEntity<String>(headers),
                    String.class,
                    word);
            if(!responseEntity.getStatusCode().equals(HttpStatus.OK)) return false;
            else return true;
        }catch(Exception ex){
//            System.out.println(ex.getMessage());
            return false;
        }

//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://wordsapiv1.p.rapidapi.com/words/"+word+"/typeOf")
//                .get()
//                .addHeader("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", "a41a35e2b0msh1e1c56482658460p120f19jsnbf6bc72252a5")
//                .build();
//
//        try (Response response = client.newCall(request).execute()) {
//            if (response.code() == 200) return true;
//            else return false;
//        }
//        return true;
    }
    @Override
    public List<String> combine(List<String> first, List<String> second, List<String> third) {
        List<String> ans = new ArrayList<>();
        for(String fst: first){
            for(String sec: second){
                for(String trd: third){
                    ans.add(fst+" "+sec+" "+trd);
                }
            }
        }
        return ans;
    }
}
