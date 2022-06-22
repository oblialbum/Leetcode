package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1471 {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int mid = (n - 1) / 2;
        int[] ans = new int[k];
        for(int i = 0,j = n - 1;i <= j && k > 0;){
            if(Math.abs(arr[j] - arr[mid]) >= Math.abs(arr[i] - arr[mid])){
                ans[ans.length - k] = arr[j];
                j--;
            }
            else{
                ans[ans.length - k] = arr[i];
                i++;
            }
            k--;
        }
        return ans;
    }
    public static void main(String[] args){
        new D_1471().getStrongest(new int[]{1,2,3,4,5},2);
    }
}
