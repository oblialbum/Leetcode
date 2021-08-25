package com.fengtin.LeetCode;

public class D_1718 {
    boolean[] visited;
    int[] ans;
    public int[] constructDistancedSequence(int n) {
        visited = new boolean[n+1];
        ans = new int[2 * n - 1];
        dfs(0,ans.length,n);
        return ans;
    }

    private boolean dfs(int pos,int length,int n){
        if(pos == length){
            return true;
        }
        /**
         * 剪枝1：当前位置已经存在数字，进行下一次递归。
         */
        if(ans[pos] != 0 ){
            return dfs(pos+1,length,n);
        }
        for(int i = n;i > 0;i--){
            if(visited[i]){
                continue;
            }
            /**
             * 剪枝2：在当前位置想要添加的该数字无法一次添加俩个，第二个会越界。
             */
            if(i > 1 && pos + i >= length){
                continue;
            }
            /**
             * 剪枝3：第二个数字添加的位置已经存在元素。
             */
            if(i > 1 && ans[i + pos] != 0){
                continue;
            }
            visited[i] = true;
            if( i == 1){
                ans[pos] = i;
                if(dfs(pos+1,length,n)){
                    return true;
                }
                ans[pos] = 0;
            }
            if(i != 1){
                ans[pos] = ans[pos+i] = i;
                if(dfs(pos+1,length,n)){
                    return true;
                }
                ans[pos] = ans[pos + i] = 0;
            }
            visited[i] = false;
        }
        return false;
    }
    public static void main(String[] args){
        Long begin =System.currentTimeMillis();
        for ( int i:new D_1718().constructDistancedSequence(50)
             ) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(System.currentTimeMillis() - begin +"ms");
    }
}
