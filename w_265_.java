package com.fengtin.LeetCode;

import java.util.*;

public class w_265_ {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(i % 10 == nums[i]){
                return i;
            }
        }
        return -1;
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next == null){
            return new int[]{-1,-1};
        }
        List<Integer> list = new ArrayList<Integer>();
        ListNode p = head.next,pre = head,next = head.next.next;
        int pos = 2;
        while (next != null){
            if(p.val > pre.val && p.val > next.val){
                list.add(pos);
            }
            else if(p.val < pre.val && p.val < next.val){
                list.add(pos);
            }
            pre = p;
            p = next;
            next = next.next;
            pos++;
        }
        if(list.size() < 2){
            return new int[]{-1,-1};
        }
        else{
            int minDistance = Integer.MAX_VALUE;
            for(int i = 0;i < list.size() - 1;i++){
                minDistance = Math.min(minDistance,list.get(i+1) - list.get(i));
            }
            return new int[]{minDistance,list.get(list.size() - 1) - list.get(0)};
        }
    }



    public static void main(String[] args){
        System.out.println(3 ^ 6);
        System.out.println(6 ^ 3);
        System.out.println(5 ^ 6);
        System.out.println(3 ^ 5);
    }
}
