package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class D_399 {
    Map<String,Map<String,Double>> map;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        map = new HashMap<>(2 * n);
        for (int i = 0; i < n; i++) {
            String key1 = equations.get(i).get(0);
            String key2 = equations.get(i).get(1);
            Map<String,Double> sub = map.getOrDefault(key1,new HashMap<>());
            sub.put(key2,values[i]);
            map.put(key1,sub);
            sub = map.getOrDefault(key2,new HashMap<>());
            sub.put(key1,1 / values[i]);
            map.put(key2,sub);
        }
        double[] ans = new double[queries.size()];
        int i = 0;
        System.out.println(map);
        for (List<String> query:queries
             ) {
            if(!map.containsKey(query.get(0)) || !map.containsKey(query.get(1))){
                ans[i++] = -1d;
                continue;
            }
            ans[i++] = dfs(query.get(0),query.get(1),1,new HashSet<String>());
        }
        return ans;
    }

    private double dfs(String begin, String end,double weight ,HashSet<String> set) {
        System.out.println(begin+","+end+","+weight);
        if(begin.equals(end)){
            return weight;
        }
        if(set.contains(begin)){
            return -1d;
        }
        set.add(begin);
        for (Map.Entry<String,Double> entry:map.get(begin).entrySet()
             ) {
            double ans = dfs(entry.getKey(),end,entry.getValue() * weight,set);
            if(ans != -1){
                return ans;
            }
        }
        return -1d;
    }
}
