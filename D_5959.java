package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_5959 {
    int res = 0;
    public int kIncreasing(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            res += split(arr,k,i);
        }
        return res;
    }

    private int split(int[] arr, int k, int pos) {
        List<Integer> list = new ArrayList<>();
        for (int i = pos; i < arr.length; i += k) {
            list.add(arr[i]);
        }
        return list.size() - lis(list);
    }

    private int lis(List<Integer> list) {
        int len = 1,n = list.size();
        if(list.isEmpty()){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[len] = list.get(0);
        for (int i = 1; i < n; ++i) {
            if(list.get(i) >= dp[len]){
                dp[++len] = list.get(i);
            }else{
                int l = 1,r = len,pos = 0;
                while (l <= r){
                    int mid = (l + r) >> 1;
                    if(dp[mid] <= list.get(i)){
                        pos = mid;
                        l = mid + 1;
                    }
                    else{
                        r = mid - 1;
                    }
                }
                dp[pos + 1] = list.get(i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        new D_5959().kIncreasing(new int[]{4,1,5,2,6,2},2);
    }
}
