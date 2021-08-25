package com.fengtin.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class D_98 {
    /**
     * 只能保证每个节点和它的俩个子节点时一颗二叉搜索树。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 非递归直接判断.
     * @param root
     * @return
     */
    public boolean judgeValid(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


    private boolean dfs(TreeNode root, long lower, long high) {
        if (root == null) {
            return true;
        }
        if (root.val > high || root.val < lower) {
            return false;
        }
        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, high);
    }
}
