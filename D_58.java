package com.fengtin.LeetCode;

public class D_58 {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0 ){
            return 0;
        }
        int index = s. length();
        for(int i = s. length() - 1; i >= 0;i--){
            if(s.charAt(i) != ' '){
                index = i;
                break;
            }
        }
        if(index == s.length()){
            return  0;
        }
        int length = 0;
        for(int i = index;i >= 0;i--){
            if(s.charAt(i) != ' '){
                length++;
            }
            else{
                break;
            }
        }
        return length;
    }
    public static void main(String[] args){
        new D_58().lengthOfLastWord("  ");
    }
}
