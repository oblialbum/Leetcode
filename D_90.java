package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_90 {
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(ans,new ArrayList<Integer>(),nums,0,visited);
        return ans;
    }
    private static void dfs(List ans,List list,int[] nums,int pos,boolean[] visited) {
        if (pos == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        if (pos > 0 && (nums[pos] == nums[pos - 1]) && visited[pos - 1] == false) {
            dfs(ans, list, nums, pos + 1,visited);
        }
        else {
            list.add(nums[pos]);
            visited[pos] = true;
            dfs(ans, list, nums, pos + 1,visited);
            list.remove(list.size() - 1);
            visited[pos] = false;
            dfs(ans, list, nums, pos + 1,visited);
        }
    }
    public static void main(String[] args){
        System.out.println(subsetsWithDup(new int[]{0}));
    }
}
