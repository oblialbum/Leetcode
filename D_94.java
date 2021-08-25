package com.fengtin.LeetCode;

import java.util.*;

public class D_94 {
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return ans;
        }
        iteratorByStack(root);
        return ans;
    }

    /**
     * 递归
     * @param root
     */
    private void dfs(TreeNode root){
        if(root.left != null){
            dfs(root.left);
        }
        ans.add(root.val);
        if(root.right != null){
            dfs(root.right);
        }
    }

    /**
     * 借助栈进行模拟递归操作，前中后序均可以参考此方法，仅需改变入栈顺序。
     * @param root
     */
    private void iteratorByStack(TreeNode root){
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(!visited.contains(cur)){
                visited.add(cur);
                if(cur.right !=null) {
                    stack.push(cur.right);
                }
                stack.push(cur);
                if(cur.left != null){
                    stack.push(cur.left);
                }
            }
            else{
                ans.add(cur.val);
            }
        }
    }

    /**
     * 显示的模拟递归中的栈，只适用于中序遍历，标准解法。
     * @param root
     */
    private void iterator(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
    }
    
}
