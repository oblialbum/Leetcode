package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_105 {
    /**
     * 根据中序，前序生成二叉树。
     * 前序遍历的第一个节点是二叉树的root，可以将中序遍历分为左右子树俩个部分。
     * @param preorder
     * @param inorder
     * @return
     */
    Map<Integer,Integer> inMap = new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = inMap.get(root.val);
        int size_left_subTree = index;
        root.left = dfs(0+1,0+size_left_subTree,0,index - 1,preorder,inorder);
        root.right = dfs(size_left_subTree + 1, preorder.length - 1, index + 1, inorder.length - 1, preorder, inorder);
        return root;
    }

    private TreeNode dfs(int preBegin,int preEnd,int inBegin,int inEnd,int[] preorder,int[] inorder){
        if( preEnd == preBegin){
            return new TreeNode(preorder[preEnd]);
        }
        if(preEnd < preBegin){
            return  null;
        }
        TreeNode root = new TreeNode(preorder[preBegin]);
        int index = inMap.get(root.val);
        int size_left_subTree = index - inBegin;
        root.left = dfs(preBegin + 1,preBegin+size_left_subTree,inBegin,index - 1,preorder,inorder);
        root.right = dfs(preBegin+size_left_subTree + 1, preEnd, index + 1, inEnd, preorder, inorder);
        return root;
    }

}
