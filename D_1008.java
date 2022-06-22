package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D_1008 {
    /**
     * 8,5,1,7,10,12
     * 1,5,7,8,10,12
     * 中序+前序构造二叉搜索树。
     *  递归。
     * @param preorder
     * @return
     */
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder,preorder.length);
        Arrays.sort(inorder);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length - 1,0,inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pre_left, int pre_right,int in_left,int in_right) {
        if(pre_left > pre_right || in_left > in_right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_left]);
        int mid = map.get(preorder[pre_left]);
        root.left = build(preorder,pre_left + 1,mid - in_left + pre_left,in_left,mid - 1);
        root.right = build(preorder,mid - in_left + pre_left + 1,pre_right,mid + 1,in_right);
        return root;
    }
}
