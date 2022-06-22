package com.fengtin.LeetCode;

public class D_237 {
    /**
     * 没给整体的链表结构，只告诉了当前需要删除的节点，同时保持链表的结构。
     * @param node
     */
    public void deleteNode(ListNode node) {
        while (true) {
            node.val = node.next.val;
            if(node.next.next == null){
                node.next = null;
                break;
            }
            node = node.next;
        }
    }
}
