package com.fengtin.LeetCode;

public class D_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }
        ListNode ans = new ListNode(),pre = ans,begin = head,newPre;
        ans.next = head;
        while(true){
            newPre = begin;
            if(( begin = reverseKNode(pre,begin,k)) == null){
                break;
            }
            pre = newPre;
        }
        return ans.next;
    }

    private ListNode reverseKNode(ListNode pre,ListNode begin, int k) {
        if(begin == null){
            return null;
        }
        ListNode end = begin;
        while(end != null && k > 1){
            end = end.next;
            k--;
        }
        /**
         * 不足K个节点。
         */
        if(end == null){
            return null;
        }
        ListNode next = end.next,p = begin.next;
        while(p != next){
            begin.next = p.next;
            p.next = pre.next;
            pre.next = p;
            p = begin.next;
        }
        return next;
    }

    public static void main(String[] args){
        int[] node = new int[]{1,2,3,4,5};
        ListNode head = new ListNode(node[0]),p = head;
        for(int i = 1;i < node.length;i++){
            p.next = new ListNode(node[i]);
            p = p.next;
        }
        new D_25().reverseKGroup(head,3);
    }
}
