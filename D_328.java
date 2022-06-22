package com.fengtin.LeetCode;

public class D_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode oddTail = head,evenTail = head.next,odd = head.next.next,next;
        while(odd != null){
            if(odd.next != null) {
                next = odd.next.next;

                evenTail.next = odd.next;
                odd.next = oddTail.next;
                oddTail.next = odd;
                oddTail = oddTail.next;
                evenTail = evenTail.next;

                odd = next;
            }
            else{
                evenTail.next = odd.next;
                odd.next = oddTail.next;
                oddTail.next = odd;
                break;
            }
        }
        return head;
    }

    public static void main(String[] args){
        int[] links = new int[]{1,2,3,4,5};
        ListNode head = new ListNode(links[0]),p;
        p = head;
        for(int i = 1;i < links.length;i++){
            p.next = new ListNode(links[i]);
            p = p.next ;
        }
        new D_328().oddEvenList(head);
    }
}
