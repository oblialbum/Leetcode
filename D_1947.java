package com.fengtin.LeetCode;

public class D_1947 {
    int ans = 0;
    int sum = 0;
    int[][] score;
    boolean[] visit1,visit2;
        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            visit1  = new boolean[students.length];
            visit2 = new boolean[students.length];
            score = new int [students.length][students.length];
            for(int i = 0;i < students.length;i++){
                for(int j = 0;j < mentors.length;j++){
                    score[i][j] = grades(students[i],mentors[j]);
                }
            }
            dfs(0,students.length);
            return ans;
        }
    
        private void dfs(int pos,int length){
            if(pos  == length){
                ans = Math.max(ans,sum);
                return;
            }
            for(int j = 0;j < length;j++){
                if(visit2[j]){
                    continue;
                }
                visit2[j] = true;
                sum += score[pos][j];
                dfs(pos+1,length);
                sum -= score[pos][j];
                visit2[j] = false;
            }
        }

    private int grades(int[] students,int[] mentors){
        int count = 0;
        for(int i = 0;i < students.length;i++){
            if(students[i] == mentors[i]){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(new D_1947().maxCompatibilitySum(new int[][]{{1,1,0},{1,0,1},{0,0,1}},new int[][]{{1,0,0},{0,0,1},{1,1,0}}));
    }
}

