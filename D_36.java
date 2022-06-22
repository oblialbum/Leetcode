package com.fengtin.LeetCode;

public class D_36 {
    boolean[][] row  = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][][] block = new boolean[9][3][3];
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i < board.length ;i++){
            for(int j = 0 ;j < board.length; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                /**
                 * 判断行是否重复。
                 */
                int setTrue = board[i][j] - '1';
                if(row[i][setTrue]){
                    return false;
                }
                else{
                    row[i][setTrue] = true;
                }
                /**
                 * 判断列是否重复。
                 */
                if(column[j][setTrue]){
                    return false;
                }
                else{
                    column[j][setTrue] = true;
                }
                /**
                 * 处理block。
                 */
                int blockIndex = (i /3) * 3 + j / 3;
                if(block[blockIndex][setTrue / 3][setTrue % 3]){
                    return false;
                }
                else{
                    block[blockIndex][setTrue / 3][setTrue % 3] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[][] temp = new String[][]{{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};
        char[][] use = new char[temp.length][temp.length];
        for(int i = 0;i < use.length;i++){
            for(int j = 0;j < use.length;j++){
                use[i][j] = temp[i][j].charAt(0);
            }
        }
        new D_36().isValidSudoku(use);
    }
}
