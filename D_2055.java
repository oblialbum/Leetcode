package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|'){
                list.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            int begin = queries[i][0],end = queries[i][1];
            //查询在list中的val，是否存在 begin<= val<=end,且两个val不相等，返回其在list中的下标。
            int first = binSearchFirst(list,begin,end),last = binSearchLast(list,begin,end);
            if (first == -1 || end == -1 || end == first){
                res[i] = 0;
            }else{
                res[i] = list.get(last) - list.get(first) - 1 - (last - first - 1);
            }
        }
        return res;
    }

    private int binSearchLast(List<Integer> list, int begin, int end) {
        int res = -1;
        int low = 0,high = list.size() - 1;
        while (low <= high){
            int mid = low + (high - low )/2;
            if (list.get(mid) <=end && list.get(mid) >= begin){
                res = mid;
                low = mid + 1;
            }
            if (list.get(mid) > end){
                high = mid - 1;
            }
            if (list.get(mid) < begin){
                low = mid + 1;
            }
        }
        return res;
    }

    private int binSearchFirst(List<Integer> list, int begin, int end) {
        int res = -1;
        int low = 0,high = list.size() - 1;
        while (low <= high){
            int mid = low + (high - low )/2;
            if (list.get(mid) <=end && list.get(mid) >= begin){
                res = mid;
                high = mid - 1;
            }
            if (list.get(mid) > end){
                high = mid - 1;
            }
            if (list.get(mid) < begin){
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new D_2055().platesBetweenCandles("||*", new int[][]{{2,2}});
    }
}
