package com.fengtin.LeetCode;

public class D_1319 {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1){
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            int node1 = connection[0], node2 = connection[1];
            uf.union(node1, node2);
        }
        return uf.getCount() - 1;
    }
}
