package com.fengtin.LeetCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D_1289 {

    public int minFallingPathSum(int[][] grid) {
        if(grid.length == 1){
            return  grid[0][0];
        }
        int[][] DP = new int[grid.length][grid.length];
        /**
         * firstMin,secondMin分别记录上一层的最小值和第二小值的下标。
         */
        int firstMin = 0,secondMin = 1;
        if( grid[0][firstMin] > grid[0][secondMin]){
            firstMin = 1;
            secondMin = 0;
        }
        for(int i = 0;i < grid.length;i++){
            DP[0][i] = grid[0][i];
            if(i > 1){
                if(grid[0][i] < grid[0][firstMin]){
                    secondMin = firstMin;
                    firstMin = i;
                }
                else if(grid[0][i] < grid[0][secondMin]){
                    secondMin = i;
                }
            }
        }
        for(int i = 1;i <grid.length;i++){
            int tempFirstMin = -1,tempSecondMin = -1;
            for(int j = 0;j < grid.length;j++){
                if(j != firstMin){
                    DP[i][j] = grid[i][j] + DP[i - 1][firstMin];
                }
                else{
                    DP[i][j] = grid[i][j] + DP[i - 1][secondMin];
                }
                if(j == 1){
                    if(DP[i][j - 1] < DP[i][j]){
                        tempFirstMin = 0;
                        tempSecondMin = 1;
                    }
                    else {
                        tempFirstMin = 1;
                        tempSecondMin = 0;
                    }
                }
                if(j > 1){
                    if(DP[i][j] < DP[i][tempFirstMin]){
                        tempSecondMin = tempFirstMin;
                        tempFirstMin = j;
                    }
                    else if(DP[i][j] < DP[i][tempSecondMin]){
                       tempSecondMin = j;
                    }
                }
            }
            firstMin = tempFirstMin;
            secondMin = tempSecondMin;
        }
        return DP[grid.length - 1][firstMin];
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[][] test = new int[200][200];
        Scanner scanner = new Scanner(new File("C:\\Users\\王鑫\\IdeaProjects\\hello_idea\\src\\com\\fengtin\\LeetCode\\data.txt"));
        String s = scanner.nextLine();
        String[] data = s.split(",");
        int count = 0;
        for(int i = 0;i < test.length;i++){
            for(int j = 0;j < test.length;j++){
                test[i][j] = getInt(data[count]);
                count++;
            }
        }
        new D_1289().minFallingPathSum(test);
    }

    private static int getInt(String s) {
        int ans = 0;
        int symbols = 1;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '-'){
                symbols = -1;
            }
            if(s.charAt(i) > '9' || s.charAt(i) < '0'){
                continue;
            }
            ans *= 10;
            ans += s.charAt(i) - '0';
        }
        return ans * symbols;
    }
}
