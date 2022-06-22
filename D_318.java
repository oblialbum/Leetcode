package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class D_318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        boolean[][] array = new boolean[n][26];
        for (int i = 0; i < n; i++) {
            for (char c:words[i].toCharArray()
                 ) {
                array[i][c-'a'] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int index = -1;
            for (int j = i + 1; j < n; j++) {
                boolean containSameChar = false;
                for (int k = 0; k < 26; k++) {
                    if(array[i][k] && array[j][k]){
                        containSameChar = true;
                        break;
                    }
                }
                if(!containSameChar){
                    index = j;
                }
            }
            if(index != -1){
                ans = Math.max(words[i].length() * words[index].length(),ans);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        new D_318().maxProduct(new String[]{"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"});
    }
}
