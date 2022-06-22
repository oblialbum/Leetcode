package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            int[][] ans = new int[1][2];
            ans[0] = newInterval;
            return ans;
        }
        List<int[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(intervals));
        int index = search(list,newInterval);
        list.add(index,newInterval);
        List<int[]> ans = new ArrayList<>();
        int start = list.get(0)[0],end = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)[0] > end){
                ans.add(new int[]{start,end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
            else{
                end = Math.max(end,list.get(i)[1]);
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[][]{});
    }

    private int search(List<int[]> list, int[] newInterval) {
        if(newInterval[0] >= list.get(list.size() - 1)[0]){
            return list.size();
        }
        if(newInterval[0] <= list.get(0)[0]){
            return 0;
        }
        int l = 0,r = list.size() - 1;
        while (l < r){
            int mid = l + (r - l ) / 2;
            if(list.get(mid)[0] < newInterval[0]){
                l = mid + 1;
            }
            if(list.get(mid)[0] == newInterval[0]){
                return mid;
            }
            if(list.get(mid)[0] > newInterval[0]){
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        new D_57().insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
    }
}
