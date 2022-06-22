package com.fengtin.LeetCode;

import java.util.Stack;

public class D_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p ;
        Stack<ListNode> stack1 = new Stack<>(),stack2 = new Stack<>();
        p = l1;
        while(p != null){
            stack1.push(p);
            p = p.next;
        }
        p = l2;
        while(p != null){
            stack2.push(p);
            p = p.next;
        }
        int carry = 0,sum;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            p = stack1.pop();
            sum = p.val + stack2.pop().val + carry;
            carry =  sum / 10;
            p.val = sum % 10;
        }

        if(stack2.isEmpty() && stack1.isEmpty()){
            if(carry > 0){
                ListNode newHead = new ListNode(carry);
                newHead.next = l1;
                return newHead;
            }
            return l1;
        }
        else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                p = stack1.pop();
                sum = p.val + carry;
                carry =  sum / 10;
                p.val = sum % 10;
            }
            if(carry > 0){
                ListNode newHead = new ListNode(carry);
                newHead.next = l1;
                return newHead;
            }
            return l1;
        }
        else {
            p = stack2.pop();
            p.next = l1;
            sum = p.val + carry;
            carry =  sum / 10;
            p.val = sum % 10;
            while(!stack2.isEmpty()){
                p = stack2.pop();
                sum = p.val + carry;
                carry =  sum / 10;
                p.val = sum % 10;
            }
            if(carry > 0){
                ListNode newHead = new ListNode(carry);
                newHead.next = l2;
                return newHead;
            }
            return l2;
        }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        ListNode second = new ListNode(9);
        new D_445().addTwoNumbers(head,second);
    }
}
