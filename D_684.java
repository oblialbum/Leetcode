package com.fengtin.LeetCode;

public class D_684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0] - 1,node2 = edge[1] - 1;
            if(uf.isConnected(node1,node2)){
                return new int[]{node1 + 1,node2 + 1};
            }
            else {
                uf.union(node1,node2);
            }

        }
        return new int[]{};
    }

    public static void main(String[] args) {
        new D_684().findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}});
    }
}
