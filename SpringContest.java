package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpringContest {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] opertion:operations
             ) {
            int from = opertion[0],to = opertion[1];
            int change = gem[from] / 2;
            gem[from] -= change;
            gem[to] += change;
        }
        int max = 0,min = Integer.MAX_VALUE;
        for (int num:gem
             ) {
            max = Math.max(num,max);
            min = Math.min(num,min);
        }
        return max - min;
    }
    int res = -1;
    int cur = 0;
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        dfs(materials,cookbooks,attribute,limit,0);
        return res;
    }

    private void dfs(int[] materials, int[][] cookbooks, int[][] attribute, int limit, int pos) {
        if (pos == cookbooks.length){
            if (limit <= 0){
                res = Math.max(res,cur);
            }
            return;
        }
        if (enough(materials,cookbooks,pos)){
            limit -= attribute[pos][1];
            cur += attribute[pos][0];
            for (int i = 0; i < materials.length; i++) {
                materials[i] -= cookbooks[pos][i];
            }
            dfs(materials, cookbooks, attribute, limit, pos+1);
            for (int i = 0; i < materials.length; i++) {
                materials[i] += cookbooks[pos][i];
            }
            cur -= attribute[pos][0];
            limit += attribute[pos][1];
        }
        dfs(materials, cookbooks, attribute, limit, pos+1);
    }

    private boolean enough(int[] materials, int[][] cookbooks, int pos) {
        for (int i = 0; i < materials.length; i++) {
            if (materials[i] < cookbooks[pos][i]){
                return false;
            }
        }
        return true;
    }


    List<Integer> list;
    int n;
    public int getNumber(TreeNode root, int[][] ops) {
        list = new ArrayList<>();
        dfs(root);
        n = list.size();
        Tree tree = new Tree(n);
        for (int[] op:ops
             ) {
            int left = Collections.binarySearch(list,op[1]);
            int right = Collections.binarySearch(list,op[2]);
            tree.update(left,right,0,op[0]);
        }
        return tree.tree[0].sum;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    class Tree{
        class node{
            int left,right;
            int sum,type;
            void fun(int n){
                type = n;
                sum = (right - left + 1) * n;
            }
        }
        node[] tree ;
        Tree(int n){
            tree = new node[4 * n];
            build(0,n - 1,0);
        }

        private void build(int left, int right, int idx) {
            tree[idx] = new node();
            tree[idx].left = left;
            tree[idx].right = right;
            tree[idx].sum = 0;
            tree[idx].type = -1;
            if (left != right){
                int mid = (tree[idx].left + tree[idx].right) /2;
                build(left,mid,idx * 2 + 1);
                build(mid + 1,right,idx * 2 + 2);
            }
        }

        private void update(int st,int en,int idx,int val){
            int left = tree[idx].left;
            int right = tree[idx].right;
            if (left >= st && right <= en){
                tree[idx].fun(val);
            }else {
                rest(idx);
                int mid = (tree[idx].left + tree[idx].right) /2;
                if (st <= mid){
                    update(st,en,idx *2 + 1,val);
                }
                if (en > mid){
                    update(st,en,idx *2 + 2,val);
                }
                tree[idx].sum = tree[idx * 2 + 1].sum + tree[idx * 2 + 2].sum;
            }
        }

        private void rest(int idx) {
            if (tree[idx].type != -1){
                tree[idx * 2 + 1].fun(tree[idx].type);
                tree[idx * 2 + 2].fun(tree[idx].type);
                tree[idx].type = -1;
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right= new TreeNode(5);
        new SpringContest().getNumber(root,new int[][]{{1,2,4},{1,1,3},{0,3,5}});
    }
}
