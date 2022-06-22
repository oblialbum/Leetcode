package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_412 {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            if(n % 15 == 0){
                ans.add("FizzBuzz");
                continue;
            }
            if(n % 3 == 0){
                ans.add("Fizz");
                continue;
            }
            if(n % 5 == 0){
                ans.add("Buzz");
                continue;
            }
            ans.add("" + i);
        }
        return ans;
    }
}
