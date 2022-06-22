package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new LinkedList<>();
        int idx = Arrays.binarySearch(arr,x);
        int left = -1,right = -1,n = arr.length;
        if(idx >= 0){
            left = idx -1;
            right = idx + 1;
            list.add(x);
            k--;
            while (k > 0){
                if(left < 0){
                    break;
                }
                if(right > n - 1){
                    break;
                }
                if(x - arr[left] <= arr[right] - x){
                    list.add(0,arr[left]);
                    left--;
                }
                else{
                    list.add(arr[right]);
                    right++;
                }
                k--;
            }
            if(k != 0){
                if(left < 0){
                    while (k > 0){
                        k--;
                        list.add(arr[right++]);
                    }
                }
                else{
                    while (k > 0){
                        k--;
                        list.add(0,arr[left--]);
                    }
                }
            }
            return list;
        }
        else{
            left = - idx - 1 - 1;
            right = - idx - 1;
            while (k > 0){
                if(left < 0){
                    break;
                }
                if(right > n - 1){
                    break;
                }
                if(x - arr[left] <= arr[right] - x){
                    list.add(0,arr[left]);
                    left--;
                }
                else{
                    list.add(arr[right]);
                    right++;
                }
                k--;
            }
            if(k != 0){
                if(left < 0){
                    while (k > 0){
                        k--;
                        list.add(arr[right++]);
                    }
                }
                else{
                    while (k > 0){
                        k--;
                        list.add(0,arr[left--]);
                    }
                }
            }
            return list;
        }
    }
}
