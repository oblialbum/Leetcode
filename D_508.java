package com.fengtin.LeetCode;

import java.util.*;

public class D_508 {
    List<Integer> ans = new ArrayList<Integer>();
    List<Integer> test = new ArrayList<Integer>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        Collections.sort(ans);
        int count = 1,max = 0;
        for(int i = 1;i < ans.size() ;i++){
            if(ans.get(i).equals(ans.get(i - 1))){
                count++;
            }
            else{
                if(count > max){
                    max = count;
                    test.clear();
                    test.add(ans.get(i - 1));
                }
                else if(count == max){
                    test.add(ans.get(i - 1));
                }
            }
        }
        if(count > max ){
            test.clear();
            test.add(ans.get(ans.size()-1));
        }
        else if (count == max){
            test.add(ans.get(ans.size()-1));
        }
        int[] res = new int[test.size()];
        for(int i = 0;i < test.size();i++){
            res[i] = test.get(i);
        }
        return res;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int cur = left + right + root.val;
        ans.add(cur);
        return cur;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        new D_508().findFrequentTreeSum(root);
    }
}
