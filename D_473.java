package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_473 {
    /**
     * 火柴拼成正方形
     * 思路：首先四等分火柴长度，找四个子集，子集和为1/4总和
     * @param matchsticks 数组每个元素代表一个火柴，元素大小=火柴的长度。
     * @return  是否可以拼成一个正方形
     */
    private static boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int i = 0;i< matchsticks.length; i++){
            sum += matchsticks[i];
        }
        if(sum % 4 != 0){
            return false;
        }
        if(sum <= 3 ){
            return false;
        }
        sum /= 4;
        Arrays.sort(matchsticks);
        boolean[] path = new boolean[matchsticks.length];
        return dfs(sum,0,0,0,matchsticks,path);
    }

    private static boolean dfs(int target,int curSum,int times,int pos,int[] matchsticks,boolean[] path){
        if(times == 4){
            return true;
        }
        if(curSum == target){
            return dfs(target,0,times+1,0,matchsticks,path);
        }
        for(int i = pos;i < matchsticks.length;i++){
            if(path[i]){
                continue;
            }
            if(curSum + matchsticks[i] > target){
                continue;
            }
            path[i] = true;
            if(dfs(target,curSum+matchsticks[i],times,i+1,matchsticks,path)){
                return true;
            }
            path[i] = false;
            /**
             * 从当前nums[i]进行递归无法得到和为target的子集，则从下一个值为nums[i]开始也无法得到和为target的子集.
             * 前者比后者拥有更多的数据进行选择。
             */
            while(i < matchsticks.length-1 && matchsticks[i] == matchsticks[i+1]){
                i++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(makesquare(new int[]{3,3,3,3,4}));
    }

}
