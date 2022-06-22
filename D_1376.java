package com.fengtin.LeetCode;

import java.util.ArrayList;

public class D_1376 {
    int max = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Node root = buildTree(manager,informTime);
        dfs(root,0);
        return max;
    }

    /**
     * dfs求最大消耗时间
     * @param root
     * @param sum
     */
    private void dfs(Node root,int sum) {
        if (root.val == 0){
            max = Math.max(sum,max);
            return;
        }
        for (Node child:root.children
             ) {
            dfs(child,sum + root.val);
        }
    }

    /**
     * 建树
     * @param manager
     * @param informTime
     * @return
     */
    private Node buildTree(int[] manager, int[] informTime) {
        int n = manager.length;
        Node[] arr = new Node[n];
        Node root = null;
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(informTime[i]);
            if (manager[i] == -1){
                root = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1){
                if (arr[manager[i]].children == null){
                    arr[manager[i]].children = new ArrayList<>();
                }
                arr[manager[i]].children.add(arr[i]);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        new D_1376().numOfMinutes(6,2,new int[]{2,2,-1,2,2,2},new int[]{0,0,1,0,0,0});
    }
}
