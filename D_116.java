package com.fengtin.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class D_116 {
    private class Node{
        int val;
        Node left;
        Node right;
        Node next;
    }
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        Node temp ;
        while(!queue.isEmpty()){
            int curSize = queue.size();
            temp = queue.poll();
            if(temp.left != null) {
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                queue.offer(temp.right);
            }
            for(int i = 0;i < curSize - 1;i++){
                temp = temp.next = queue.poll();
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        dfs(root,root.left,root.right);
        return root;
    }

    private void dfs(Node root,Node left,Node right){
        if(root == null || left == null){
            return;
        }
        left.next = right;
        if(root.next != null){
            right.next = root.next.left;
        }
        dfs(left,left.left,left.right);
        dfs(right,right.left,right.right);

    }
}
