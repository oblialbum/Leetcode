package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class D_954 {
    /**
     * 长度范围内，arr[2i+1] = 2* arr[2i],即技术位置是偶数位置的2倍数。
     * @param arr
     * @return
     */
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> postiveMap = new HashMap<>();
        HashMap<Integer, Integer> negativeMap = new HashMap<>();
        int zeroCnts = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                postiveMap.put(arr[i], postiveMap.getOrDefault(arr[i], 0) + 1);
            }else if (arr[i] < 0){
                negativeMap.put(arr[i], negativeMap.getOrDefault(arr[i], 0) + 1);
            }else{
                zeroCnts++;
            }
        }
        if (zeroCnts % 2 != 0){
            return false;
        }
        int target,cur;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || !postiveMap.containsKey(arr[i])){
                continue;
            }
            cur = arr[i];
            target = 2 * cur;
            if (postiveMap.get(target) == null){
                return false;
            }
            postiveMap.put(target,postiveMap.get(target) - 1);
            postiveMap.put(cur,postiveMap.get(cur) - 1);
            if (postiveMap.get(target) == 0){
                postiveMap.remove(target);
            }
            if (postiveMap.get(cur) == 0){
                postiveMap.remove(cur);
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 0 || !negativeMap.containsKey(arr[i])){
                continue;
            }
            cur = arr[i];
            target = 2 * cur;
            if (negativeMap.get(target) == null){
                return false;
            }
            negativeMap.put(target,negativeMap.get(target) - 1);
            negativeMap.put(cur,negativeMap.get(cur) - 1);
            if (negativeMap.get(target) == 0){
                negativeMap.remove(target);
            }
            if (negativeMap.get(cur) == 0){
                negativeMap.remove(cur);
            }
        }
        return postiveMap.isEmpty() && negativeMap.isEmpty();
    }
}
