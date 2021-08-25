package com.fengtin.LeetCode;

public class D_357 {
    private static int countNumbersWithUniqueDigits(int n) {
        boolean[] path = new boolean[10];
        return dfs(n,path,0,false);
    }
    private static int dfs(int n,boolean[] path,int pos,boolean occurs){
        if(pos == n){
            return 1;
        }
        int count = 0;
        for(int i = 0;i < 10;i++) {
            if(occurs)
            {
                if (path[i]) {
                    continue;
                }
            }
            else{
                if(path[i] && i!= 0){
                    continue;
                }
            }
            path[i] = true;
            if(i != 0){
                occurs = true;
            }
            count += dfs(n, path, pos + 1, occurs);
            //occurs = false;
            path[i] = false;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(countNumbersWithUniqueDigits(3));
    }
}
