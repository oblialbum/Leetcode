package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D_1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0;i < matrix.length;i++){
            int min = 100001,minIndex = -1;
            for(int j = 0;j < matrix[i].length;j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    minIndex = j;
                }
            }
            if(set.contains(minIndex)){
                continue;
            }
            boolean isLucky = true;
            for(int j = 0;j < matrix[i].length;j++){
                if(matrix[j][minIndex] > min){
                    isLucky = false;
                    break;
                }
            }
            if(isLucky){
                set.add(minIndex);
                ans.add(matrix[i][minIndex]);
            }
        }
        return ans;
    }
}
