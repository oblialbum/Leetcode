package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SummaryRanges {
    List<List<Integer>> ans ;
    Set<Integer> set;
    int size = 0;
    public SummaryRanges() {
        ans = new ArrayList<>();
        set = new HashSet<>();
    }

    public void addNum(int val) {
        if(size == 0){
            List<Integer> list = new ArrayList<>();
            list.add(val);
            list.add(val);
            ans.add(list);
            set.add(val);
            size++;
        }
        else{
            /**
             *二分查找应该插入的位置。
             */
            size++;
            if(set.contains(val)){
                return;
            }
            set.add(val);
            int left = 0,right = ans.size() - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(val > ans.get(mid).get(1)){
                    left = mid + 1;
                }
                if(val < ans.get(mid).get(0)){
                    right = mid - 1;
                }
            }
            /**
             * 该元素应该放在left位置，左边元素小，右边元素大。
             * 分情况，在中间，在俩边。
             */
            if(right == -1){
                if(val == ans.get(0).get(0) - 1){
                    ans.get(0).remove(0);
                    ans.get(0).add(0,val);
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(val);
                    list.add(val);
                    ans.add(0,list);
                }
                return;
            }
            if(left == ans.size()){
                if(val == ans.get(ans.size()-1).get(1) + 1){
                    ans.get(ans.size()-1).remove(1);
                    ans.get(ans.size()-1).add(val);
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(val);
                    list.add(val);
                    ans.add(list);
                }
                return;
            }
            if(val == ans.get(left - 1).get(1) + 1 && val == ans.get(left).get(0) - 1 ){
                int max = ans.get(left).get(1);
                ans.get(left - 1).remove(1);
                ans.get(left - 1).add(max);
                ans.remove(left);
            }
            else if(val == ans.get(left - 1).get(1) + 1){
                ans.get(left - 1).remove(1);
                ans.get(left - 1).add(val);
            }
            else if(val == ans.get(left).get(0) - 1){
                ans.get(left).remove(0);
                ans.get(left).add(0,val);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(val);
                list.add(val);
                ans.add(left,list);
            }
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[ans.size()][2];
        for(int i = 0;i < ans.size();i++){
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }
        return res;
    }

    public static void main(String[] args){
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);      // arr = [1]
        summaryRanges.getIntervals(); // 返回 [[1, 1]]
        summaryRanges.addNum(3);      // arr = [1, 3]
        summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
    }
}
