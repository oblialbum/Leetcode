package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class W_257 {
    /**
     * 不能排序,草。
     * @param nums
     * @return
     */
    int ans ;
    List<Integer> list = new ArrayList<Integer>();
    public int countQuadruplets(int[] nums) {
        if(nums.length < 4){
            return 0;
        }
        dfs(nums,0,0,0);
        return ans;
    }

    private void dfs(int[] nums, int pos, int times,int sum) {
        if(times == 4){
            if(sum == 0){
                ans++;
            }
            return;
        }
        for(int i = pos;i < nums.length -(3 - times);i++){
            if(times < 3) {
                sum += nums[i];
                dfs(nums, i + 1, times + 1, sum);
                sum -= nums[i];
            }
            else{
                sum -= nums[i];
                dfs(nums, i + 1, times + 1, sum);
                sum += nums[i];
            }
        }
    }

    /**
     * 基数排序？
     * 第一位相同的化为一组，从组中第一个位置开始比较，如果成功则继续，失败则跳到下一组中。
     * @param properties
     * @return
     */
    public int numberOfWeakCharacters(int[][] properties) {
        int ans = 0;
        Arrays.sort(properties, (o, p) -> o[0] == p[0] ? o[1] - p[1] : p[0] - o[0]);
        for(int i = 0;i < properties.length; i++){
            for(int j = properties.length-1; j > i;j--) {
                if (properties[i][0] < properties[j][0]) {
                    if (properties[i][1] < properties[j][1]) {
                        ans++;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[][] t = new int[][]{{100000,100000},{100000,99999}};
        new W_257().numberOfWeakCharacters(t);
    }
}
