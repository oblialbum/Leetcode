package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_77 {
    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans,new ArrayList<Integer>(),n,k, 1);
        return ans;
    }
    private static void dfs(List ans,List list,int n,int k,int index){
        if(k == list.size() ){
            ans.add(new ArrayList(list));
            return ;
        }
        for(int i = index;i <= n - (k - list.size()) + 1;i++) {
            list.add(i);
            dfs(ans, list, n, k,i+1);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args){
        System.out.println(combine(4,2));
    }
}
