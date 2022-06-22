package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int[] DP = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        DP[0] = 1;
        map.put(arr[0],0);
        for (int i = 1; i < n; i++) {
            DP[i] = 1;
            if(map.containsKey(arr[i] - difference)){
                DP[i] = DP[map.get(arr[i] - difference)] + 1;
            }
            for(int j = i - 1;j >=0;j--){
                if(arr[i] - arr[j] == difference){
                    DP[i] = DP[j] + 1;
                    break;
                }
            }
            map.put(arr[i],i);
        }
        int max = 1;
        for (int len:DP
             ) {
            max = Math.max(len,max);
        }
        return max;
    }

    public static void main(String[] args){
        new D_1218().longestSubsequence(new int[]{4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8},0);
    }
}
