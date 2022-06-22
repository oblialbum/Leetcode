package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class W_65 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] occur = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            occur[word1.charAt(i) - 'a']++;
            occur[word2.charAt(i) - 'a']--;
        }
        for (int num: occur
             ) {
            if(num > 3 || num < -3){
                return false;
            }
        }
        return true;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0] == 0 ?  - a[1] + b[1]:a[0] - b[0];
            }
        });
        int curMax = items[0][1];
        /**
         * 当前价格能够得到的物品中的最大美丽度
         */
        for (int i = 0; i < items.length; i++) {
            if(items[i][1] > curMax){
                curMax = items[i][1];
            }
            items[i][1] = curMax;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int[] item: items
             ) {
            if(map.containsKey(item[0]) && map.get(item[0]) < item[1]){
                map.replace(item[0],item[1]);
            }
            if(!map.containsKey(item[0])){
                map.put(item[0],item[1]);
            }
        }
        map.put(0,0);
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(map.floorKey(queries[i]));
        }
        return ans;
    }
}
