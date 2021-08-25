package com.fengtin.LeetCode;

public class D_559 {
    int ans;
    public int maxDepth(Node root) {
        dfs(root,0);
        return ans;
    }

    private void dfs(Node root,int depth){
        if(root == null){
            ans = Math.max(depth,ans);
            return;
        }
        for (Node node: root.children
             ) {
            dfs(node,depth+1);
        }
    }
}
