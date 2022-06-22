package com.fengtin.LeetCode;

public class D_547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind UF = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != j && isConnected[i][j] == 1){
                    UF.union(i,j);
                }
            }
        }
        return UF.getCount();
    }

    public static void main(String[] args) {
        
    }
}
