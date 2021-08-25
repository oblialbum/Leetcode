package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_216 {
    /**
     *
     * @param k k个数
     * @param n 和为n
     * @return
     */
    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList();
        boolean[] visited = new boolean[10];
        dfs(n,k,visited,ans,new ArrayList<Integer>());
        return ans;
    }
    private static void dfs(int sum,int times,boolean[] visited,List ans,List list){
        if(times == 0 && sum == 0){
            ans.add(new ArrayList<Integer>(list));
        }
        for(int i = 1;i < 10 ;i++){
            if(sum - i >= 0 && visited[i] == false){
                list.add(i);
                visited[i] = true;
                dfs(sum - i,times - 1 ,visited,ans,list);
                visited[i] = false;
                list.remove(list.size()-1);
            }
            else{
                break;
            }
        }
    }
    public static void main(String[] args){
        System.out.println(combinationSum3(3,9));
    }
}
