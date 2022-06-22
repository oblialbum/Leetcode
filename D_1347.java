package com.fengtin.LeetCode;

public class D_1347 {
    public int minSteps(String s, String t) {
        int[] visited = new int[26];
        for (int i = 0; i < s.length(); i++) {
            visited[s.charAt(i)]++;
            visited[t.charAt(i)]--;
        }
        int sum = 0;
        for (int num: visited
             ) {
            if(num > 0){
                sum += num;
            }
        }
        return sum;
    }
}
