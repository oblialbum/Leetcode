package com.fengtin.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class D_99 {
    /**
     * 二叉搜索树的俩个节点被交换了位置，将其恢复。
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode first = null, preFirst = new TreeNode(Integer.MIN_VALUE), second = null;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (first == null && root.val < preFirst.val) {
                first = preFirst;
            }

            if (first != null && root.val < preFirst.val) {
                second = root;
            }
            preFirst = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
