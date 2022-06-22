package com.fengtin.LeetCode;

import java.util.Arrays;

public class W_62 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != (m * n)){
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        for(int i = 0;i < original.length; i++){
            ans[i / n][i % n] = original[i];
        }
        return ans;
    }

    /**
     * T2.
     */
    public int numOfPairs(String[] nums, String target) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(nums[i].length() >= target.length()){
                continue;
            }
            boolean isPrefix = true;
            for(int j = 0;j < nums[i].length();j++){
                if(nums[i].charAt(j) != target.charAt(j)){
                    isPrefix = false;
                    break;
                }
            }
            if(!isPrefix){
                continue;
            }
            int left = 0,right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(compare(nums[mid],target.substring(nums[i].length(),target.length())) < 0){
                    left = mid + 1;
                }
                if(compare(nums[mid],target.substring(nums[i].length(),target.length())) > 0){
                    right = mid - 1;
                }
                if(nums[mid].equals(target.substring(nums[i].length(),target.length()))){
                    if(mid != i){
                        ans++;
                    }
                    int temp = mid + 1;
                    while(temp < nums.length){
                        if(nums[temp].equals(target.substring(nums[i].length(),target.length()))){
                            if(temp != i){
                                ans++;
                            }
                            temp++;
                        }
                        else{
                            break;
                        }
                    }
                    temp = mid - 1;
                    while(temp >= 0){
                        if(nums[temp].equals(target.substring(nums[i].length(),target.length()))){
                            if(temp != i){
                                ans++;
                            }
                            temp--;
                        }
                        else{
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return ans;
    }
    public int compare(String s1,String s2){
        for(int i = 0;i < s1.length() && i < s2.length();i++){
            if(s1.charAt(i) < s2.charAt(i)){
                return -1;
            }
            if(s1.charAt(i) > s2.charAt(i)){
                return 1;
            }
        }
        return s1.length() - s2.length();
    }

    /**
     * T4
     * N*N,过了70%。
     * @param nums
     * @param k
     * @return
     */
    public int waysToPartition(int[] nums, int k) {
        int[] originalDP = new int[nums.length];
        originalDP[0] = nums[0];
        int ans = 0;
        for(int i = 1;i < nums.length;i++){
            originalDP[i] = originalDP[i - 1] + nums[i];
        }
        for(int i = 1;i < nums.length;i++){
            if(originalDP[i - 1] * 2 == originalDP[nums.length - 1]){
                ans++;
            }
        }
        for(int i = 0;i < nums.length;i++){
            //第一重循环，将第nums[i]赋值为k；
            int diff = k - nums[i];
            int[] newDP = new int[nums.length];
            for(int j = 0;j < nums.length;j++){
                if(j < i){
                    newDP[j] = originalDP[j];
                }
                else{
                    newDP[j] = originalDP[j] + diff;
                }
            }
            int curAns = 0;
            for(int j = 1;j < nums.length;j++){
                if(newDP[j - 1] * 2 == newDP[nums.length - 1]){
                    curAns++;
                }
            }
            ans = Math.max(ans,curAns);
        }
        return ans;
    }


    public static void main(String[] args){
        new W_62().waysToPartition(new int[]{2,-1,2},3);
    }
}
