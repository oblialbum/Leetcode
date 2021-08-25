package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;


public class D_131 {
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s,ans,new ArrayList<String>(),0);
        return ans;
    }
    private static void dfs(String s,List answer,List list,int pos){
        if(pos == s.length()){
            answer.add( new ArrayList(list));
            return;
        }
        for(int i = pos;i< s.length(); i++){
            if(s.charAt(i) == s.charAt(pos)){
                if(isHuiWen(pos,i,s)){
                    list.add(s.substring(pos,i+1));
                    dfs(s,answer,list,i+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    /**
     *
     * @param begin 字串开始的位置
     * @param end   字串结束的位置
     * @param s
     * @return
     */
    private static boolean isHuiWen(int begin,int end,String s){
        while(end >= begin){
            if(s.charAt(begin) != s.charAt(end)){
                return false;
            }
            end--;
            begin++;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(partition("a"));
    }
}
