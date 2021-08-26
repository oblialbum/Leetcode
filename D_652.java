package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D_652 {
    List<TreeNode> ans = new ArrayList<TreeNode>();
    Map<String,Integer> hashMap = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return ans;
    }

    private String serialize(TreeNode root) {
        if(root == null){
            return "null";
        }
        String s = root.val+"," + serialize(root.left) +"," + serialize(root.right);
        if(!hashMap.containsKey(s)){
            hashMap.put(s,1);
        }
        else if(hashMap.get(s) == 1){
            ans.add(root);
            hashMap.replace(s,2);
        }
        return s;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(1);
        new D_652().findDuplicateSubtrees(root);
    }
}
