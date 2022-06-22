package com.fengtin.LeetCode;

public class D_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lengthA = 0,lengthB = 0;
        ListNode pa = headA,pb = headB;
        while(pa != null){
            pa =pa.next;
            lengthA++;
        }
        while(pb != null){
            pb =pa.next;
            lengthB++;
        }
        pa = headA;
        pb = headB;
        if(lengthA == lengthB){
            while(pa != null && pb != null && pa != pb){
                pa = pa.next;
                pb = pb.next;
            }
            return pa;
        }
        else if(lengthA < lengthB){
            int offset = lengthB - lengthA;
            while (offset > 0){
                pb =pb.next;
                offset--;
            }
            while(pa != null && pb != null && pa != pb){
                pa = pa.next;
                pb = pb.next;
            }
            return pa;
        }
        else {
            int offset = lengthA - lengthB;
            while (offset > 0){
                pa =pa.next;
                offset--;
            }
            while(pa != null && pb != null && pa != pb){
                pa = pa.next;
                pb = pb.next;
            }
            return pa;
        }
    }
}
