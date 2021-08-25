package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_89 {
    /**
     * 格雷编码:通過基本的回溯得到： n位的格雷編碼是n+1位格雷編碼的前綴。
     */
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> grayCode(int n) {
        ans.add(0);
        boolean[] visited = new boolean[(int)Math.pow(2,n)];
        visited[0] = true;
        dfs(0,1,-1,n,visited,ans);
        return ans;
    }
    private boolean dfs(int pre,int pos,int diff ,int length,boolean[] visited,List<Integer> ans){
        if(pos == (int)Math.pow(2, length)){
            return true;
        }

        for(int i = 0;i < length;i++){
            if(i == diff) continue;
            int cur = pre + transform(pre,i);
            if( cur < Math.pow(2,length)){
                if(!visited[cur]){
                    visited[cur] = true;
                    ans.add(cur);
                    if(dfs(cur,pos+1,i,length,visited,ans)){
                        return true;
                    }
                    ans.remove(ans.size() - 1);
                    visited[cur] = false;
                }
            }
        }


        return false;
    }

    private int transform(int cur,int pos){
        int res = (int)Math.pow(2,pos);
        cur /= res;
        return cur % 2 == 0 ? res :-1 * res;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new D_89().grayCode(i));
        }
    }
}
