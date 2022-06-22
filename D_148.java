package com.fengtin.LeetCode;

public class D_148 {
    /**
     * 归并排序链表。
     * 1;将链表递归划分，直到只有1/0个节点。
     * 2.将划分后的节点进行归并排序。
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
       return partition(head);

    }

    private ListNode partition(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first,second;
        second = partition(getMid(head));
        first = partition(head);

        return sort(first,second);
    }

    /**
     * 链表会被截断。
     * @param head
     * @return next Node of mid Node of linkList.
     */
    private ListNode getMid(ListNode head){
        ListNode slow = head,fast = head.next ;
        while(fast != null){
            if(fast.next != null){
                fast = fast.next.next ;
            }
            else{
                break;
            }
            slow = slow.next;
        }
        ListNode ans = slow.next;
        slow.next = null;
        return ans;
    }

    private ListNode sort(ListNode first,ListNode second){
        ListNode dummy = new ListNode(),end = dummy;
        while(first != null && second !=null){
            if(first.val < second.val){
                end.next = first;
                first = first.next ;

            }
            else{
                end.next = second;
                second = second.next ;
            }
            end = end.next;
            end.next = null;
        }
        if (first != null){
            end.next = first;
        }
        if(second != null){
            end.next = second;
        }
        return dummy.next ;
    }

    public static void main(String[] args){
        int[] nodeVal = new int[]{-1,5,3,4,0};
        ListNode head = new ListNode(nodeVal[0]),p = head;
        for(int i = 1;i < nodeVal.length;i++){
            p.next = new ListNode(nodeVal[i]);
            p = p.next;
        }
        new D_148().sortList(head);
    }
}
