package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])){
                    if (i + j < minSum){
                        minSum = i + j;
                        list.clear();
                        list.add(list1[i]);
                    }else if(i + j == minSum){
                        list.add(list1[i]);
                    }
                    break;
                }
            }
        }
        return list.toArray(new String[]{});
    }
}
