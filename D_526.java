package com.fengtin.LeetCode;

public class D_526 {
    public static int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        return dfs(1,n,visited);
    }
    private static int dfs(int pos,int n,boolean[] visited){
        if(pos == n+1){
            return 1;
        }


        int count = 0;
        for(int i = 1;i <= n;i++){
            if(visited[i]){
                continue;
            }
            if(pos % i != 0 && i % pos != 0){
                continue;
            }
            visited[i] = true;
            count += dfs(pos+1,n,visited);
            visited[i] = false;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(countArrangement(3));
    }
}
