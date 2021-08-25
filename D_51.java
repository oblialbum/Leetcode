package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_51 {
    /**
     * N皇后.
     * @param n
     * @return
     */
    List<List<String>> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();
    char[][] NQueens;
    boolean[] visited;
    public List<List<String>> solveNQueens(int n) {
        NQueens = new char[n][n];
        visited = new boolean[n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++) {
                NQueens[i][j] = '.';
            }
        }
        dfs(0,n);
        return ans;
    }
    private void dfs(int pos,int length){
        if(pos == length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0;i < length;i++){
            if(visited[i]){
                continue;
            }
            if(!canAttack(pos,i)){
                visited[i] = true;
                NQueens[pos][i]='Q';
                list.add(new String(NQueens[pos]));
                dfs(pos+1,length);
                list.remove(pos);
                NQueens[pos][i]='.';
                visited[i] = false;
            }
        }
    }

    /**
     * 调用函数之前，当前Queen和上一个不在同一行，同一列。仅需要处理是否在同意对角线上。
     * 查看(i-1,j+1),(i-1,j-1)是否存在queen。
     * @param i
     * @param j
     * @return
     */
    private boolean canAttack(int i,int j){
        if(i == 0){
            return false;
        }
        if(j == 0){
            int temp =  1;
            while(i - temp >= 0){
                if(NQueens[i - temp][j + temp] == 'Q'){
                    return true;
                }
                temp++;
            }
            return false;
        }
        if(j == NQueens.length - 1){
            int temp = 1;
            while(i - temp >= 0){
                if(NQueens[i - temp][j - temp] == 'Q'){
                    return true;
                }
                temp++;
            }
            return false;
        }
        int temp  = 1;
        while(i - temp >= 0){
            if(j - temp >= 0){
                if(NQueens[i - temp][j - temp] == 'Q'){
                    return true;
                }
            }
            if(j + temp < NQueens.length){
                if(NQueens[i - temp][j + temp] == 'Q'){
                    return true;
                }
            }
            temp++;
        }
        return false;
    }
    public static void main(String[] args){
        for(int i = 1;i < 15;i++){
            System.out.println(new D_51().solveNQueens(i).size());
        }
        /**
         * [["Q....","..Q..","....Q",".Q...","...Q."],["Q....","...Q.",".Q...","....Q","..Q.."],[".Q...","...Q.","Q....","..Q..","....Q"],
         * [".Q...","....Q","..Q..","Q....","...Q."],["..Q..","Q....","...Q.",".Q...","....Q"],["..Q..","....Q",".Q...","...Q.","Q...."],
         * ["...Q.","Q....","..Q..","....Q",".Q..."],["...Q.",".Q...","....Q","..Q..","Q...."],["....Q",".Q...","...Q.","Q....","..Q.."],
         * ["....Q","..Q..","Q....","...Q.",".Q..."]]
         */
    }
}
