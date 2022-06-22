package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D_1436 {
    public String destCity(List<List<String>> paths) {
        Map<String,String> map = new HashMap<>();
        for (List<String> list: paths
             ) {
            map.put(list.get(0),list.get(1));
        }
        String curDestination = paths.get(0).get(1);
        while(map.containsKey(curDestination)){
            curDestination = map.get(curDestination);
        }
        return curDestination;
    }
}
