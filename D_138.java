package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_138 {
    public Node copyRandomList(Node head) {
        /**
         * pos1:记录原链表节点和位置的关系。
         * pos2:记录新链表位置和节点的关系。
         */
        Map<Node,Integer> pos1 = new HashMap<>();
        Map<Integer, Node> pos2 = new HashMap<>();
        if(head == null){
            return null;
        }
        Node newHead = new Node(head.val),p1 = head,p2 = newHead;
        pos1.put(head,0);
        pos2.put(0,newHead);
        /**
         * 节点，next指针拷贝。
         */
        int pos = 1;
        while(p1.next != null){
            p1 = p1.next;
            p2.next = new Node(p1.val);
            p2 = p2.next;
            pos1.put(p1,pos);
            pos2.put(pos,p2);
            pos++;
        }
        p1 = head;
        p2 = newHead;

        while(p1 != null){
            if(p1.random == null){
                p2.random = null;
            }
            else{
                p2.random = pos2.get(pos1.get(p1.random));
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return newHead;
    }


    /**
     * 回溯，创建当前节点，递归创建next,random。
     * @param head
     * @return
     */
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList1(head.next);
            headNew.random = copyRandomList1(head.random);
        }
        return cachedNode.get(head);
    }
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
