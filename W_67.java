package com.fengtin.LeetCode;

import java.util.*;

public class W_67 {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{nums[i], i});
        }
        Collections.sort(list, (x, y) -> (y[0] - x[0]));
        while (list.size() > k) {
            list.remove(list.size() - 1);
        }
        Collections.sort(list, (x, y) -> (x[1] - y[1]));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i)[0];
        }
        return ans;
    }

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> list = new ArrayList<>();
        if (n <= time * 2) {
            return list;
        }
        if (time == 0) {
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            return list;
        }
        if (time == 1) {
            for (int i = 1; i < n - 1; i++) {
                if (security[i] <= security[i - 1] && security[i] <= security[i + 1]) {
                    list.add(i);
                }
            }
            return list;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                list.add(i);
            }
        }
        return list;
    }
    boolean[] visited ;
    Map<Integer,HashSet<Integer>> map;
    public int maximumDetonation(int[][] bombs) {
        int ans = 1;
        int n = bombs.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long r = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if(j == i){
                    continue;
                }
                long x_ = bombs[i][0] - bombs[j][0];
                long y_ = bombs[i][1] - bombs[j][1];
                if(x_ * x_ + y_ * y_ <= r * r){
                    HashSet<Integer> set = map.getOrDefault(i,new HashSet<>());
                    set.add(j);
                    map.put(i,set);
                }
            }
        }
        System.out.println(map);
        for (int i = 0; i < n; i++) {
            visited =new boolean[n];
            ans = Math.max(ans, dfs(i));
            if(ans == n){
                return ans;
            }
        }
        return ans;
    }

    private int dfs(int pos) {
        if(visited[pos]){
            return 0;
        }
        visited[pos] = true;
        int ans = 1;
        for (int next:map.getOrDefault(pos,new HashSet<>())
             ) {
           ans += dfs(next);
        }
        return ans;
    }

    public static void main(String[] args) {
        new W_67().maximumDetonation(new int[][]{{1,1,100000},{100000,100000,1}});
    }

}
