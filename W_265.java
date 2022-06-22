package com.fengtin.LeetCode;

import java.util.*;

public class W_265 {
    public ListNode deleteListNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p,pre = head ;
        while (pre != null){
            p = pre.next;
            if(p == null){
                break;
            }
            pre.next = p.next;
            pre = pre.next;
        }
        return head;
    }

    public int[] analysisHistogram(int[] heights, int cnt) {
        if(heights.length < cnt){
            return new int[]{};
        }
        Arrays.sort(heights);
        int begin = 0,end = cnt - 1,min = heights[cnt - 1] - heights[0];
        for(int i = 1;i + cnt - 1 < heights.length;i++){
            if(heights[i + cnt - 1] - heights[i] < min){
                begin = i;
                end = i + cnt - 1;
                min = heights[i + cnt - 1] - heights[i];
            }
        }
        int[] ans = new int[cnt];
        for (int i = begin;i <= end;i ++){
            ans[i - begin] = heights[i];
        }
        return ans;
    }
   
}
