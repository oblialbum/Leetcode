package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_969 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        for (int end = n - 1; end > 0 ; end--) {
            reverseSort(arr,end);
        }
        System.out.println(Arrays.toString(arr));
        return list;
    }

    private void reverseSort(int[] arr, int end) {
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > arr[max]){
                max = i;
            }
        }
        if (max == end){
            return;
        }else{
            reverse(arr,max);
            reverse(arr,end);
            list.add(max+1);
            list.add(end+1);
        }
    }

    private void reverse(int[] arr, int max) {
        for (int i = 0; i < max; i++,max--) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }

    public static void main(String[] args) {
        new D_969().pancakeSort(new int[]{3,2,4,1});
    }
}
