package com.fengtin.LeetCode;

public class D_838 {
    public String pushDominoes(String dominoes) {
        //记录i之前最近的R，从0开始遍历找到L。判断最近的两个L之前是否存在R。
        char[] array = dominoes.toCharArray();
        int n = array.length;
        int[] leastR = new int[n];
        int begin = -1;
        for (int i = 0; i < n; i++) {
            leastR[i] = begin;
            if (array[i] == 'R'){
                begin = i;
            }
        }
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (array[i] == 'L'){
                if (i == 0){
                    pre = 0;
                    continue;
                }
                if (leastR[i] <= pre){
                    for (int j = Math.max(0,pre); j < i; j++) {
                        array[j] = 'L';
                    }
                }else{
                    for (int j = leastR[i],k = i; j < k; j++,k--) {
                        array[j] = 'R';
                        array[k] = 'L';
                    }
                }
                pre = i;
            }
        }
        //向左偏的已经完成，应该从n开始处理向右偏的情况。
        int[] leastL = new int[n];
        begin = n;
        for (int i = n - 1; i >= 0 ; i--) {
            leastL[i] = begin;
            if (array[i] == 'L'){
                begin = i;
            }
        }
        pre = n;
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] == 'R'){
                if (i == n - 1){
                    pre = n - 1;
                    continue;
                }
                if (leastL[i] >= pre){
                    for (int j = Math.min(n,pre); j > i; j--) {
                        array[j] = 'R';
                    }
                }else{
                    for (int j = leastL[i],k = i; j > k; j--,k++) {
                        array[j] = 'L';
                        array[k] = 'R';
                    }
                }
                pre = i;
            }
        }
        return new String(array);
    }
}
