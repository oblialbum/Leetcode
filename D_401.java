package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_401 {
    private static List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        int[] hoursAndMinutes = new int[]{8,4,2,1,32,16,8,4,2,1};
        int[] path = new int[10];
        recursion(0,turnedOn,ans,hoursAndMinutes,path);
        return ans;
    }
    private static void recursion(int pos,int n,List<String> answer,int[] hoursAndMinutes,int[] path){
        if(n == 0){
            int hour = 0,minutes = 0;
            for(int i = 0;i < 10;i++){
                if(i < 4){
                    hour += hoursAndMinutes[i] * path[i];
                }
                else{
                    minutes += hoursAndMinutes[i] * path[i];
                }
            }
            if(hour <12 && minutes < 60){
                if (minutes > 9) {
                    answer.add(hour + ":" + minutes);
                }
                else{
                    answer.add(hour + ":0" + minutes);
                }
            }
            return ;
        }
        for(int i = pos;i < 10;i++){
            path[i] = 1;
            recursion(i + 1,n-1,answer,hoursAndMinutes,path);
            path[i] = 0;
        }
    }
    public static void main(String[] args){
        System.out.println(readBinaryWatch(1));
    }
}
