package com.fengtin.LeetCode;

public class D_492 {
    public int[] constructRectangle(int area) {
        if(area < 4){
            return new int[]{area,1};
        }
        int l = (int)Math.sqrt(area);
        while(l < area){
            if(area % l == 0 && l  >= (area / l)){
                return new int[]{l,area / l};
            }
        }
        return new int[]{area,1};
    }

    public static void main(String[] args){
        new D_492().constructRectangle(4);
    }
}
