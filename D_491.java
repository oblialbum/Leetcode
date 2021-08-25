package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class D_491 {
    /**
     * 回溯+循环，从俩位子序列开始，一直到N位。
     *time:11ms
     * memory:45.4M
     * @param nums
     * @return
     */
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= nums.length; i++) {
            dfs(0, i, nums, ans, list, -101);
        }
        return ans;
    }

    private static void dfs(int pos, int length, int[] nums, List ans, List list, int last) {

        if (length == 0) {
            ans.add(new ArrayList(list));
            return;
        }
        boolean[] visited = new boolean[201];
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] < last) {
                continue;
            }
            if(visited[nums[i]]){
                continue;
            }
            visited[nums[i]] = true;
            list.add(nums[i]);
            dfs(i + 1, length - 1, nums, ans, list, nums[i]);
            list.remove(list.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

    /**
     * 第二种解法，一次遍历N位子序列。
     * time:4ms
     * memory:44.8M
     * @param nums
     * @return
     */

    public static List<List<Integer>> findSubsequences2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> hashList = new HashSet<>();
        dfs2(0, nums, ans, list, -101,hashList);
        return ans;
    }
    private static void dfs2(int pos, int[] nums, List ans, List list, int last,HashSet hashList) {
        if(list.size() >= 2){
            ans.add(new ArrayList<>(list));
        }
        if(pos == nums.length){
            return;
        }
        for(int i = pos;i < nums.length;i++){
            if(nums[i] < last){
                continue;
            }
            if(hashList.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            hashList.add(nums[i]);
            dfs2(i+1,nums,ans,list,nums[i],new HashSet<Integer>());
            list.remove(list.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = findSubsequences2(new int[]{1,2,1,1});
        for (List list:ans
             ) {
            System.out.println(list);
        }
    }
}
