package com.fengtin.LeetCode;

public class D_86 {
    /**
     * 大于等于x的节点，小于x的节点。
     * 保留相对位置，不能直接交换节点值。
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode firstPre = new ListNode();
        ListNode ans = firstPre;
        firstPre.next = head;
        ListNode first = head;
        ListNode secondPre = first;
        ListNode second = head.next;
        int firstPos = 1,secondPos = 2;
        while(second != null && first != null) {
            while(first != null && first.val < x){
                first = first.next;
                firstPre = firstPre.next;
                firstPos++;
            }
            while(second != null && second.val >= x) {
                second = second.next;
                secondPre = secondPre.next;
                secondPos++;
            }
            if(first == null || second  == null){
                break;
            }
            /**
             * 当前俩个节点已经满足关系，second后移。
             */
            if(firstPos > secondPos){
                second = second.next;
                secondPre = secondPre.next;
                secondPos++;
                continue;
            }
            /**
             * 找到俩个需要交换的节点，进行交换操作，second移动到first之前。
             */
            ListNode newSecond = second.next;
            firstPre.next = second;
            second.next = first;
            secondPre.next = newSecond;
            second = newSecond;
            secondPos++;
            firstPos++;
            firstPre = firstPre.next;
        }
        return ans.next;
    }

    public static void main(String[] args){
        int[] numbers = new int[]{2,0,4,1,3,1,4,0,3};
        ListNode head = new ListNode(numbers[0]);
        ListNode p = head;
        for(int i = 1;i <numbers.length;i++){
            p.next = new ListNode(numbers[i]);
            p = p.next;
        }
        new D_86().partition(head,4);
    }
}
