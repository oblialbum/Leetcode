package com.fengtin.LeetCode;

public class D_1601 {
    int res = 0;
    int[] change ;
    public int maximumRequests(int n, int[][] requests) {
        change = new int[n];
        dfs(requests,0,0);
        return res;
    }

    private void dfs(int[][] requests, int pos, int count) {
        if (pos == requests.length){
            if (balance(change)) {
                res = Math.max(res, count);
            }
            return;
        }
        int from = requests[pos][0],to = requests[pos][1];
        change[from]--;
        change[to]++;
        dfs(requests,pos+1,count+1);
        change[from]++;
        change[to]--;
        dfs(requests,pos+1,count);
    }

    private boolean balance(int[] change) {
        for (int i = 0; i < change.length; i++) {
            if (change[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new D_1601().maximumRequests(5,new int[][]{{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}});
    }
}
