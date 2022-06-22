package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class W_258 {
    public String reversePrefix(String word, char ch) {
        char[] words = word.toCharArray();
        int index = -1;
        for(int i = 0;i < words.length;i++){
            if(words[i] == ch){
                index = i;
                break;
            }
        }
        if(index == -1){
            return word;
        }
        for(int i = 0;i < index;i++,index--){
            char temp = words[i];
            words[i] = words[index];
            words[index] = temp;
        }
        return new String(words);
    }

    public long interchangeableRectangles(int[][] rectangles) {
        long ans = 0;
        Map<Double,Integer> hashmap = new HashMap<>();
        for (int[] rectangle: rectangles
        ) {
            double height = rectangle[0];
            double width = rectangle[1];

            if(!hashmap.containsKey(height / width)){
                hashmap.put(height / width,1);
            }
            else{
                hashmap.replace(height / width ,hashmap.get(height / width) + 1);
            }
        }
        for (double d: hashmap.keySet()
        ) {
            long values = hashmap.get(d);
            ans += values * (values - 1) / 2;
        }
        return ans;
    }


    public static void main(String[] args){
       W_258 temp =  new W_258();
       int[][] rectangles = new int[][]{{4,8},{3,6},{10,20},{15,30}};
       temp.interchangeableRectangles(rectangles);
    }
}
