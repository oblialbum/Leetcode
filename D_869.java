package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class D_869 {
    Set<Integer> set = new HashSet<>();
    Set<Integer> allNums = new HashSet<>();
    boolean[] visited ;
    public boolean reorderedPowerOf2(int n) {
        if(n == 1){
            return true;
        }
        for(int i = 1;i <= Math.pow(10,9);i *=2){
            allNums.add(i);
        }
        int[] tail = new int[]{2,4,6,8};
        for (int num:tail
             ) {
            set.add(num);
        }
        int temp = n,length = 0;
        boolean flag = false;
        while (temp != 0){
            int val = temp % 10;
            if(set.contains(val)){
                flag = true;
            }
            length++;
            temp /= 10;
        }
        if(!flag){
            return false;
        }
        int[] nums = new int[length];
        visited = new boolean[length];
        for (int i = 0;i < length;i++){
            nums[i] = (n % 10);
            n /= 10;
        }
        Arrays.sort(nums);
        return dfs(nums,0,0);
    }

    private boolean dfs(int[] nums, int pos,int sum) {
        if(pos == nums.length){
            return judge(sum);
        }
        for(int i = 0;i < nums.length;i++){
            if(visited[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                continue;
            }
            if(pos == 0 && nums[i] == 0){
                continue;
            }
            visited[i] = true;
            if(dfs(nums,pos + 1,sum * 10 + nums[i])){
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    private boolean judge(int sum) {
       return allNums.contains(sum);
    }
    public static void main(String[] args){
        new D_869().reorderedPowerOf2(56635);
    }
}
