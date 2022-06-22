package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王鑫
 */
public class LRUCache {
    private class DNode{
        int val;
        DNode next;
        DNode pre;
        public DNode(int value){
            this.val = value;
        }
    }

    /**
     * P：链尾节点。
     * head:头节点。
     */
    DNode head = new DNode(-1);
    DNode p = head;
    private Map<Integer, Integer> map;
    private int leftCapacity;
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Integer>(capacity);
        leftCapacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            /**
             * 还需要其他操作，满足最近最久未使用原则。
             * 将该节点移动到最后链尾，和replace相同。
             */
            moveToEnd(key);
            return map.get(key);
        }
        return -1;
    }

    private void moveToEnd(int key) {
        DNode temp = head;
        while (true){
            if(temp.val == key){
                while (temp.next != head){
                    temp.val = temp.next.val;
                    temp = temp.next;
                }
                temp.val = key;
                break;
            }
            temp = temp.next;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.replace(key, value);
            /**
             * 删除值为key的节点，在链尾添加一个新的节点key.
             */
            moveToEnd(key);
        }
        else if(leftCapacity > 0){
            map.put(key, value);
            DNode node = new DNode(key);
            /**
             * 将节点插入链尾。
             */
            node.pre = p;
            node.next = head;
            p.next = node;
            head.pre = node;

            p = node;
            leftCapacity--;
        }
        else{
            /**
             * 删除最久未使用的数据，插入。
             * 即：删除链表第一个节点，插入链表最后一个节点。
             */
            DNode node = head.next;
            map.remove(node.val);
            map.put(key, value);
            while (node.next != head){
                node.val = node.next.val;
                node = node.next;
            }
            node.val = key;
        }
    }

    public static void main(String[] args){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1,1);
        lRUCache.put(2,2);
        lRUCache.get(1);
        lRUCache.put(3,3);
        lRUCache.get(2);
        lRUCache.put(4,4);
        lRUCache.get(1);
        lRUCache.get(3);
        lRUCache.get(4);
        System.out.println("breakPoint");
    }
}
