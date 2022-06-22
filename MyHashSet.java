package com.fengtin.LeetCode;

public class MyHashSet {
    private class Node{
        Node next;
        int value;
        public Node(int value){
            this.value = value;
        }
    }
    Node[] arr;
    int n = 767;
    public MyHashSet() {
        arr = new Node[n];
    }

    /**
     * 先判断应该填入的位置是否存在元素，即冲突。
     * 冲突情况下判断是否元素相同。
     * @param key
     */
    public void add(int key) {
        int index = getCode(key);
        if(arr[index] == null){
            arr[index] = new Node(key);
        }
        else{
            if(arr[index].value == key){
                return;
            }
            Node cur = arr[index].next,pre = arr[index];
            while(cur != null && cur.value != key){
                cur = cur.next;
                pre = pre.next;
            }
            if(cur == null){
                pre.next = new Node(key);
            }
        }
    }

    public void remove(int key) {
        int index = getCode(key);
        if(arr[index] != null){
            Node p = arr[index].next,pre = arr[index];
            if(pre.value == key){
                arr[index] = arr[index].next;
            }
            while(p!= null && p.value != key){
                p = p.next;
                pre = pre.next;
            }
            if(p == null){
                return;
            }
            else{
                pre.next = p.next;
            }
        }
    }

    public boolean contains(int key) {
        Node cur = arr[getCode(key)];
        while(cur != null){
            if(cur.value == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private int getCode(int value){
        return value % n;
    }
}
