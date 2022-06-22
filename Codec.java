package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化，先序遍历。
 */
public class Codec {
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        dfs(root.left,sb);
        dfs(root.right,sb);
    }

    public TreeNode deserialize(String data){
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs2(queue);
    }

    private TreeNode dfs2(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = dfs2(queue);
        root.right = dfs2(queue);
        return root;
    }
}
