package com.fengtin.LeetCode;

public class D_130 {
    int n ,m;
    public void solve(char[][] board) {
        if(board.length == 0){
            return;
        }
        n = board.length;
        m = board[0].length;
        for(int i = 0;i < n;i++){
            dfs(board,i,0);
            dfs(board,i,m-1);
        }
        for(int j = 0;j < m;j++){
            dfs(board,0,j);
            dfs(board,n-1,j);
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(board[i][j] == '#'){
                    board[i][j] ='O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board,int row,int column){
        if(row < 0 || column < 0 || row >= n || column >= m || board[row][column] !='O'){
            return;
        }
        board[row][column] = '#';
        dfs(board,row + 1,column);
        dfs(board,row - 1,column);
        dfs(board,row,column + 1);
        dfs(board,row,column - 1);
    }

    public static void main(String[] args){

        String[][] original = new String[][]{{"X","X","X","X","X"},{"X","O","O","O","X"},{"X","X","O","O","X"},{"X","X","X","O","X"},{"X","O","X","X","X"}};
        char[][] board = new char[original.length][original[0].length];
        for(int i = 0 ;i < original.length; i++){
            for(int j = 0 ;j < original[0].length; j++) {
                board[i][j] = original[i][j].charAt(0);
            }
        }
        new D_130().solve(board);

    }
}
