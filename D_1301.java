package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * E 1 1
 * X X X
 * 1 1 S
 */
public class D_1301 {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] DP = new int[n][n];
        int[][] nums = new int[n][n];
        int mod = (int)(Math.pow(10,9))+7;
        /**
         * 初始化：最后一行和最后一列。
         */
        for(int i = n - 2;i >= 0;i--){
            if(board.get(n - 1).charAt(i) == 'X'){
                break;
            }
            nums[n - 1][i] = 1;
            DP[n - 1][i]  = DP[n - 1][i + 1] + board.get(n - 1).charAt(i) - '0';
        }
        for(int i = n - 2;i >= 0;i--){
            if(board.get(i).charAt(n - 1) == 'X'){
                break;
            }
            nums[i][n - 1] = 1;
            DP[i][n - 1] = DP[i + 1][n - 1] + board.get(i).charAt(n - 1) - '0';
        }
        nums[n - 1][n- 1] = 1;
        for(int i = n- 2;i >= 0;i--){
            for(int j = n- 2;j >= 0;j--){
                if(board.get(i).charAt(j) == 'X'){
                    continue;
                }
                if(DP[i][j + 1] == DP[i + 1][j]  && DP[i + 1][j] == DP[i + 1][j + 1]){
                    DP[i][j] = DP[i][j + 1] ;
                    nums[i][j] = nums[i][j + 1] + nums[i + 1][j] + nums[i + 1][j + 1];
                }
                else if(DP[i][j + 1] == DP[i + 1][j]){
                    if(DP[i + 1][j + 1] > DP[i][j + 1]){
                        DP[i][j] = DP[i+1][j + 1] ;
                        nums[i][j] = nums[i+1][j + 1];
                    }
                    else{
                        DP[i][j] = DP[i+1][j];
                        nums[i][j] = nums[i+1][j] + nums[i][j + 1];
                    }
                }
                else if(DP[i + 1][j] == DP[i + 1][j + 1]){
                    if(DP[i][j + 1] > DP[i + 1][j]){
                        DP[i][j] = DP[i][j + 1];
                        nums[i][j] = nums[i][j + 1];
                    }
                    else{
                        DP[i][j] = DP[i+1][j];
                        nums[i][j] = nums[i+1][j] + nums[i + 1][j + 1];
                    }
                }
                else if(DP[i][j + 1] == DP[i + 1][j + 1]){
                    if(DP[i + 1][j] > DP[i][j + 1]){
                        DP[i][j] = DP[i + 1][j];
                        nums[i][j] = nums[i + 1][j];
                    }
                    else{
                        DP[i][j] = DP[i+1][j + 1];
                        nums[i][j] = nums[i][j + 1] + nums[i + 1][j + 1];
                    }
                }
                else{
                    int max = DP[i + 1][j],maxNum = nums[i  +1][j];
                    if(max < DP[i + 1][j + 1]){
                        max = DP[i + 1][j + 1];
                        maxNum = nums[i + 1][j + 1];
                    }
                    if(max < DP[i][j + 1]){
                        max = DP[i][j + 1];
                        maxNum = nums[i][j + 1];
                    }
                    DP[i][j] = max ;
                    nums[i][j] = maxNum;
                }
                if(board.get(i).charAt(j) !='E' && nums[i][j] != 0) {
                    DP[i][j] += board.get(i).charAt(j) - '0';
                }
                nums[i][j] %= mod;
                DP[i][j] %= mod;
            }
        }
        return new int[]{DP[0][0],nums[0][0]};
    }

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("E11");
        list.add("XXX");
        list.add("11S");
        new D_1301().pathsWithMaxScore(list);
    }
}
