package com.fengtin.LeetCode;

public class D_419 {
    public int countBattleships(char[][] board) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'X'){
                    board[i][j] = '.';
                    for (int k = i + 1; k < board.length &&board[k][j] =='X' ; k++) {
                        board[k][j] = '.';
                    }
                    for (int k = j + 1; k < board[i].length &&board[i][k] =='X' ; k++) {
                        board[i][k] = '.';
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
