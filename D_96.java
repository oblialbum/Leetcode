package com.fengtin.LeetCode;

public class D_96 {

    public int numTrees(int n) {
        int[] type = new int[n+1];
        type[0] = 1;
        type[1] = 1;
        type[2] = 2;
        for(int i = 3;i <= n;i++) {
            for(int j = 1;j <= i;j++){
             type[i] += type[j - 1] * type[i - j];
            }
        }
        return type[n];
    }

    public static void main(String[] args){
        System.out.println(new D_96().numTrees(4));
    }
}
