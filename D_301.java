package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D_301 {
    List<String> ans = new ArrayList<>();
    Set<String> set = new HashSet<>();
    int minRemoveNum = Integer.MAX_VALUE;
    int left ,right,max;
    public List<String> removeInvalidParentheses(String s) {
        int l = 0 ,r = 0;
        for (char c: s.toCharArray()
             ) {
            if(c == '('){
                l++;
            }
            if(c == ')'){
                r++;
            }
        }
        max = Math.min(l,r);
        dfs(s,0,new StringBuffer(),0);
        for (String key: set
             ) {
            ans.add(key);
        }
        return ans;
    }

    private void dfs(String s, int pos, StringBuffer sb,int removeNum) {
        if(left < right || left > max || right > max){
            return;
        }
        if(pos == s.length()){
            if(left == right) {
                if (removeNum == minRemoveNum) {
                    set.add(sb.toString());
                }
                if (removeNum < minRemoveNum) {
                    minRemoveNum = removeNum;
                    set.clear();
                    set.add(sb.toString());
                }
            }
            return;
        }
        if(removeNum > minRemoveNum){
            return;
        }
        if(s.charAt(pos) == '('){
            left++;
        }
        if(s.charAt(pos) == ')'){
            right++;
        }
        sb.append(s.charAt(pos));
        dfs(s,pos + 1,sb,removeNum);

        if(s.charAt(pos) == '('){
            left--;
        }
        if(s.charAt(pos) == ')'){
            right--;
        }
        sb.delete(sb.length() - 1,sb.length());
        dfs(s,pos + 1,sb,removeNum + 1);
    }

    public static void main(String[] args){
        new D_301().removeInvalidParentheses("((((((((((((((((((((aaaaa");
    }
}
