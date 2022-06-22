package com.fengtin.LeetCode;

import java.util.*;

public class D_987 {
    int shift = 0;
    TreeMap<dotPair,ArrayList<Integer>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs1(root,0);
        map = new TreeMap<>((o1, o2) -> o1.y -o2.y == 0 ?o1.x - o2.x:o1.y-o2.y);
        dfs2(res,root,0,0);
        map.forEach((x,y)->{
            if (y.size() > 1){
                Collections.sort(y);
            }
            while (res.size() < x.y + 1){
                res.add(new ArrayList<>());
            }
            for (int val:y
                 ) {
                res.get(x.y).add(val);
            }
        });
        return res;
    }

    private void dfs2(List<List<Integer>> res,TreeNode root, int row,int col) {
        if (root == null){
            return;
        }
        dfs2(res,root.left,row+1,col - 1);
        ArrayList<Integer> list = map.getOrDefault(new dotPair(row,col - shift), new ArrayList<>());
        list.add(root.val);
        map.put(new dotPair(row,col - shift),list);
        dfs2(res,root.right,row+1,col + 1);
    }

    private void dfs1(TreeNode root, int col) {
        if (root == null){
            return;
        }
        dfs1(root.left,col - 1);
        dfs1(root.right,col + 1);
        shift = Math.min(col,shift);
    }

    class dotPair{
        public dotPair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x,y;

        @Override
        public int hashCode() {
            return x*1003 +7*y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof dotPair){
                return ((dotPair) obj).x == x && ((dotPair) obj).y == y;
            }
            return false;
        }

        @Override
        public String toString() {
            return x+","+y;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        new D_987().verticalTraversal(root);
    }
}
