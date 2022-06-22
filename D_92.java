package com.fengtin.LeetCode;

public class D_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return  head;
        }
        int count = 1;
        ListNode ans = new ListNode(),pre;
        ans.next = head;
        pre = ans;
        while(count < left){
            head = head.next;
            pre = pre.next;
            count++;
        }
        ListNode second = head;
        while(count < right){
            second = second.next;
            count++;
        }
        ListNode next = second.next;
        dfs(head,second);
        head.next = next;
        pre.next = second;
        return ans.next;
    }

    /**
     * 翻转局部链表[left,right]
     * @param left
     * @param right
     */
    private void dfs(ListNode left, ListNode right) {
        if(left == right){
            return;
        }
        dfs(left.next,right);
        left.next.next = left;
        left.next = null;
    }

    public static void main(String[] args){
        int[] list = new int[]{1,2,3,4,5};
        ListNode head = new ListNode(list[0]),p;
        p = head;
        for(int i = 1;i < list.length;i++){
            p.next = new ListNode(list[i]);
            p = p.next;
        }
        new D_92().reverseBetween(head,1,5);
    }

}
