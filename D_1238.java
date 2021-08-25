package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_1238 {
    /**
     *
     * @param n 二进制数的长度.
     * @param start
     * @return
     */
    public List<Integer> circularPermutation(int n, int start) {
        boolean[] visited = new boolean[(int)Math.pow(2,n)];
        visited[start] = true;
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(start);
        dfs(start,-1,1,n,ans,visited);
        return ans;
    }

    private boolean dfs(int pre,int different,int pos,int length,List<Integer> answer,boolean[] visited){
        if(pos == (int)Math.pow(2,length)){
            for(int i = 0;i < length;i++) {
                if (Math.abs(answer.get(0) - answer.get(answer.size() - 1)) == (int)Math.pow(2,i)) {
                    return true;
                }
            }
            return false;
        }
        for(int i = 0;i < length;i++){
            if(i != different && pre + transform(pre,i,length)  < Math.pow(2,length)) {
                if (!visited[pre + transform(pre,i,length)]) {
                    visited[pre + transform(pre,i,length)] = true;
                    answer.add(pre + transform(pre,i,length));
                    if(dfs(pre + transform(pre,i,length), i, pos + 1, length, answer,visited)){
                        return true;
                    }
                    answer.remove(answer.size() - 1);
                    visited[pre + transform(pre,i,length)] = false;
                }
            }
        }
        return false;
    }
    private int transform(int pre, int i,int n){
        int result = (int)Math.pow(2,i);
        pre /= result;
        return pre % 2 == 0 ? result: -1*result;
    }
    public static void main(String[] args){
        System.out.println(new D_1238().circularPermutation(1,0));
    }
}
