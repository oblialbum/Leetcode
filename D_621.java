package com.fengtin.LeetCode;

public class D_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] arr=new int[26];
        int m=0;
        int c=0;
        for(char v:tasks){
            arr[v-'A']++;
        }
        for(int i=0;i<26;i++){
            if(arr[i]>m){
                m=arr[i];
                c=1;
            }else if(m==arr[i]){
                c+=1;
            }
        }
        return Math.max(tasks.length,(n+1)*(m-1)+c);
    }
}
