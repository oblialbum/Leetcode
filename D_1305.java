package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans1 = new ArrayList<Integer>();
        List<Integer> ans2 = new ArrayList<Integer>();
        dfs(root1,ans1);
        dfs(root2,ans2);
        if(ans1.size() == 0){
            return ans2;
        }
        if(ans2.size() == 0){
            return ans1;
        }
        List<Integer> ans = new ArrayList<Integer>();
        int i = 0,j = 0;
        for (;;){
            while(i < ans1.size() && ans1.get(i) <= ans2.get(j)){
                ans.add(ans1.get(i));
                i++;
            }
            if (i == ans1.size()){
                break;
            }
            while(j < ans2.size() && ans2.get(j) <= ans1.get(i)){
                ans.add(ans2.get(j));
                j++;
            }
            if(j == ans2.size()){
                break;
            }
        }
        if (i == ans1.size()){
            for(;j < ans2.size();){
                ans.add(ans2.get(j));
                j++;
            }
        }
        if(j == ans2.size()){
            for(;i < ans2.size();){
                ans.add(ans1.get(i));
                i++;
            }
        }
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if(root == null){
            return;
        }
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }
    
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        new D_1305().getAllElements(root1,root2);
    }
}
