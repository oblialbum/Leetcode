package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 ){
            return null;
        }
        int end = lists.length;
        for(int i = 0;i < end;){
            if(lists[i] == null){
                ListNode temp = lists[i];
                lists[i] = lists[end - 1];
                lists[ end - 1] = temp;
                end--;
                continue;
            }
            i++;
        }
        Arrays.sort(lists, 0,end,(o1, o2) -> o1.val - o2.val);
        ListNode head = new ListNode();
        ListNode p = head;
        /**
         * 赋初值。
         */
        ListNode min = lists[0];
        int minIndex = 0;
        while (minIndex != end) {
            if(min == null){
                break;
            }
            p.next = min;
            p = p.next;
            lists[minIndex] = lists[minIndex].next;

            /**
             * 进行调整，使得数组有序。
             * 2,0,1,3,4,5
             */
            for(int i = minIndex;i < end;){
                if(lists[i] == null){
                    ListNode temp = lists[i];
                    lists[i] = lists[end - 1];
                    lists[ end - 1] = temp;
                    end--;
                    continue;
                }
                i++;
            }
            Arrays.sort(lists, minIndex,end,(o1, o2) -> o1.val - o2.val);
            min = lists[0];
            System.out.println();
        }
        return head.next;
    }

    public static void main(String[] args){
        ListNode first = new ListNode(-1);
        first.next = new ListNode(5);
        first.next.next = new ListNode(11);
        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);
        ListNode third = new ListNode(6);
        third.next = new ListNode(10);
        ListNode[] lists = new ListNode[]{first,null,null,third};
        ListNode ans = new D_23().mergeKLists(lists);
        System.out.println(ans);
    }
}
