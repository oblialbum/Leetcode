package com.fengtin.LeetCode;

public class D_430 {
    /**
     * 无 child：处理下一个。
     * 有child:处理child节点，同上，再返回最后一个节点作为元链表中下一个节点的前置。
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        if(head == null){
            return null;
        }
        recursion(head);
        return head;
    }

    private Node recursion(Node head) {
        Node p = head,next,pre = null;
        while (p != null){
            if(p.child == null) {
                pre = p;
                p = p.next;
            }
            else{
                next = p.next;
                p.next = p.child;
                p.child.prev =p;
                p.child = null;
                pre = recursion(p.next);
                pre.next = next;
                if(next != null) {
                    next.prev = pre;
                }
                p = next;
            }
        }
        return pre;
    }


    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.child = new Node(2);
        head.child.child = new Node(3);
        new D_430().flatten(head);
    }
}
