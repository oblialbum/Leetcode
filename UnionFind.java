package com.fengtin.LeetCode;

public class UnionFind {
    int[] parent;
    int[] height;
    int count;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.height = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            height[i] = 1;
        }
    }

    private int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return parent[x];
    }

    /**
     * 使用该方法后会破坏树的高度，在合并查询效率上降低，暂时无修改的想法。
     * @param x
     */
    public void split(int x){
        if(parent[x] == x){
            return;
        }
        parent[x] = x;
        count++;
    }
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        if (height[rootX] > height[rootY]) {
            parent[rootY] = rootX;
            height[rootX] = Math.max(height[rootX], height[rootY] + 1);

        } else {
            parent[rootX] = rootY;
            height[rootY] = Math.max(height[rootY], height[rootX] + 1);
        }
        count--;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getCount() {
        return this.count;
    }

}
