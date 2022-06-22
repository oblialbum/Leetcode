package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D_1447 {
    static Map<Integer, ArrayList<String>> map = new HashMap<>();
    static {
        map.put(1,new ArrayList<>());
        for (int i = 2; i <= 100; i++) {
            map.put(i,new ArrayList<>());
            ArrayList<String> list = map.get(i);
            list.addAll(map.get(i - 1));
            for (int j = 1; j < i; j++) {
                if (right(i,j)){
                    list.add(j + "/"+i);
                }
            }
        }
    }

    private static boolean right(int x, int y) {
        for (int i = 1; i <= x && i <= y ; i++) {
            if (x % i == 0 && y % i == 0){
                if (i > 1){
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> simplifiedFractions(int n) {
        return map.get(n);
    }

}
