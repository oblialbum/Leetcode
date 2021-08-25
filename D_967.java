package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_967 {
    public static int[] numsSameConsecDiff(int n, int k) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char i = '1';i <= '9';i++){
            sb.append(i);
            dfs(n,k,1,ans,i,sb);
            sb.deleteCharAt(0);
        }
        int[] res = new int[ans.size()];
        for(int i = 0 ;i < res.length;i++){
            res[i] = Integer.parseInt( ans.remove(0));
        }
        return res;
    }
    private static void dfs(int n,int k,int pos,List ans,char pre,StringBuilder sb){
        if(pos == n){
            ans.add(sb.toString());
            return;
        }

        char c = (char) (pre - k);
        if(c >= '0'){
            sb.append(c);
            dfs(n,k,pos+1,ans,c,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if((char)(c+k+k) <= '9'){
            sb.append((char)(c+k+k));
            dfs(n,k,pos+1,ans,(char)(c+k+k),sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        /*for(char c = '0';c <= '9';c++){
            if(Math.abs(c - pre) == k){
                sb.append(c);
                dfs(n,k,pos+1,ans,c,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }*/
    }
    public static void main(String[] args){
        int[] ans = numsSameConsecDiff(2,1);
        for (int i: ans
             ) {
            System.out.print(i+" ");
        }
    }
}
