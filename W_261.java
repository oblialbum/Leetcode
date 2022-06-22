package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class W_261 {
    public int minimumMoves(String s) {
        int times = 0;
        int begin = 0,end = 2;
        for(;end < s.length();){
            if(s.charAt(begin) == 'X'){
                times++;
                end += 3;
                begin += 3;
            }
            else{
                begin++;
                end++;
            }
        }
        for(int i = begin;i < s.length();i++){
            if(s.charAt(i) == 'X'){
                times++;
                break;
            }
        }
        return times;
    }
    List<Integer> ans = new ArrayList<>();
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int target = mean *(rolls.length + n);
        for(int i = 0;i < rolls.length;i++){
            target -= rolls[i];
        }
        if(target > 6 * n || target < n){
            return new int[]{};
        }
        traceBack(n,target);
        int[] res = new int[ans.size()];
        for(int i = 0;i < ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    private boolean traceBack(int n, int target) {
        if(n == 0){
            return target == 0;
        }
        for(int i = 1;i <= 6;i++){
            if((target - i) > 6 * (n - 1) ||(target - i) < (n - 1)){
                continue;
            }
            ans.add(i);
            if(traceBack(n - 1,target - i)){
                return true;
            }
            ans.remove(ans.size() - 1);
        }
        return false;
    }

}