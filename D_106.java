package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_106 {
    Map<Integer,Integer> hashmap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length;i++){
            hashmap.put(inorder[i],i);
        }
        TreeNode root = buildTree(inorder,postorder,0,inorder.length - 1,0,postorder.length - 1);
        return root;
    }
    private TreeNode buildTree(int[] inorder, int[] postorder,int inBegin,int inEnd,int postBegin,int postEnd){
        /**
         * postend:该位置的节点即为当前树的root，可以在中序遍历中将树划分为左右俩部分。
         */
        if(postBegin == postEnd){
            return new TreeNode(postorder[postEnd]);
        }
        if(postBegin > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = hashmap.get(postorder[postEnd]);
        int left_size = index - inBegin;
        root.left = buildTree(inorder,postorder,inBegin,index - 1,postBegin,postBegin + left_size - 1);
        root.right = buildTree(inorder, postorder,index + 1,inEnd,postBegin + left_size,postEnd - 1);
        return root;
    }
    public static void main(String[] args){
        System.out.println(new D_106().buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3}));
    }
}
