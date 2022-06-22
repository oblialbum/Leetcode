package com.fengtin.LeetCode;

public class D_942 {
    boolean[] visited;
    public int[] diStringMatch(String s) {
        int n = s.length();
        visited = new boolean[n + 1];
        int[] ans = new int[n + 1];
        for(int i = 0;i < n + 1;i++){
            ans[0] = i;
            visited[i] = true;
            if(traceBack(s,1,ans)){
                return ans;
            }
            visited[i] = false;
        }
        return ans;
    }

    private boolean traceBack(String s, int pos, int[] ans) {
        if(pos == ans.length){
            return true;
        }
        if(s.charAt(pos - 1) == 'I'){
            for(int i = ans[pos - 1] + 1;i < ans.length;i++){
                if(visited[i]){
                    continue;
                }
                visited[i] = true;
                ans[pos] = i;
                if(traceBack(s,pos+1,ans)){
                    return true;
                }
                visited[i] = true;
            }
        }
        else{
            for(int i = ans[pos - 1] - 1;i >= 0;i--){
                if(visited[i]){
                    continue;
                }
                visited[i] = true;
                ans[pos] = i;
                if(traceBack(s,pos+1,ans)){
                    return true;
                }
                visited[i] = true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        new D_942().diStringMatch("D");

    }
}
