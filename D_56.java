package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {//两个区间有重叠
                end = Math.max(end, intervals[i][1]);
            } else {
                //两个区间没有重叠，保存[start,end]，然后更新
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start, end});
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
