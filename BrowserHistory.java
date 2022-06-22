package com.fengtin.LeetCode;

/**
 * @author 王鑫
 */
public class BrowserHistory {
    class node{
        String url;
        node next;
        node prev;
        public node(){
            this.url = "";
        }
        public node(String url){
            this.url = url;
        }
    }
    node dummy = new node(),tail = new node();
    node cur;
    int back = 0,froward = 0;
    public BrowserHistory(String homepage) {
        node temp = new node(homepage);
        dummy.next = temp;
        temp.next = tail;
        tail.next = dummy;
        dummy.prev = tail;
        tail.prev = temp;
        temp.prev = dummy;
        cur = temp;
    }

    public void visit(String url) {
        node temp = new node(url);
        cur.next = temp;
        temp.prev = cur;
        temp.next = tail;
        tail.prev = temp;
        cur = cur.next;
        froward = 0;
        back++;
    }

    public String back(int steps) {
        if(steps >= back){
            froward += back;
            back = 0;
            cur = dummy.next;
            return cur.url;
        }
        else{
            while (steps > 0){
                cur = cur.prev;
                steps--;
                froward++;
                back--;
            }
            return cur.url;
        }
    }

    public String forward(int steps) {
        if(steps >= froward){
            back += froward;
            froward = 0;
            cur = tail.prev;
            return cur.url;
        }
        else{
            while (steps > 0){
                cur = cur.next;
                steps--;
                froward--;
                back++;
            }
            return cur.url;
        }
    }
}
