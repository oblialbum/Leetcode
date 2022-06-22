package com.fengtin.LeetCode;

public class D_59 {
    int cur = 1;
    int[][] ans;
    public int[][] generateMatrix(int n) {
        ans = new int[n][n];
        for (int loop = 0;2 * loop < n;loop++){
            generateMatrix(loop,n);
        }
        return ans;
    }

    private void generateMatrix(int loop,int n) {
        int begin = loop,end = n - loop;
        for(int i = begin; i < end ;i++){
            ans[loop][i] = cur++;
        }
        for(int i = begin + 1; i < end;i++){
            ans[i][end - 1] = cur++;
        }
        for(int i = end - 2;i >= begin;i--){
            ans[end - 1][i] = cur++;
        }
        for(int i = end - 2;i > begin;i--){
            ans[i][loop] = cur++;
        }
    }
    public static void main(String[] args){
        new D_59().generateMatrix(3);
    }
}
