package com.fengtin.LeetCode;

public class D_37 {
    /**
     * 定义三个数组：输入固定是9*9矩阵。
     * 1：9*9 每行均代表0-9的数字，表示是否出现
     * 2：9*9 每列，同上
     * 3：9*（3*3）代表N个矩阵中1-9是否出现。
     */
    boolean[][] row ;
    boolean[][] column;
    boolean[][][] unit ;
    public void solveSudoku(char[][] board) {
        row = new boolean[9][9];
        column = new boolean[9][9];
        unit = new boolean[9][3][3];
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board.length;j++){
                if(board[i][j] != '.'){
                    int setTrue = board[i][j] - '1';
                    row[i][setTrue ] = true;
                    column[j][setTrue] = true;
                    unit[(i/3)*3 + j / 3][setTrue / 3][setTrue % 3] = true;
                }
            }
        }
        dfs(0,0,board);
    }
    private boolean dfs(int i,int j,char[][] board){
        if(i == board.length){
            return true;
        }
        if(board[i][j] != '.') {
            if (j == 8) {
                if(dfs(i+1, 0, board)){
                    return true;
                }
            }
            else{
                 if(dfs(i,j + 1,board)){
                     return true;
                 }
            }
        }
        else {
            for (int num = 1; num < 10; num++) {
                if (row[i][num - 1] || column[j][num - 1] || unit[(i / 3) * 3 + j / 3][(num - 1) / 3][(num - 1) % 3]) {
                    continue;
                }
                row[i][num - 1] = true;
                column[j][num - 1] = true;
                unit[(i / 3) * 3 + j / 3][(num - 1) / 3][(num - 1) % 3] = true;
                board[i][j] = (char) ('0' + num);
                if (j == 8) {
                    if(dfs(i + 1, 0, board)){
                        return true;
                    }
                } else {
                    if(dfs(i, j + 1, board)){
                        return true;
                    }
                }
                board[i][j] = '.';
                row[i][num - 1] = false;
                column[j][num - 1] = false;
                unit[(i / 3) * 3 + j / 3][(num - 1) / 3][(num - 1) % 3] = false;
            }
        }
        return false;
    }
    public static void main(String[] args){
        String[][] temp = new String[][]{{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};
        char[][] use = new char[temp.length][temp.length];
        for(int i = 0;i < use.length;i++){
            for(int j = 0;j < use.length;j++){
                use[i][j] = temp[i][j].charAt(0);
            }
        }
        new D_37().solveSudoku(use);
        for(int i = 0;i < use.length;i++){
            for(int j = 0;j < use.length;j++){
                System.out.print(use[i][j] + " ");
            }
            System.out.println();
        }
    }
}
