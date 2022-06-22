package com.fengtin.LeetCode;

public class D_917 {
    public String reverseOnlyLetters(String s) {
        char[] array = s.toCharArray();
        for (int i = 0,j = array.length - 1; i < j;) {
            while (!Character.isLetter(array[i])){
                i++;
                if (i >= j){
                    break;
                }
            }
            while (!Character.isLetter(array[j])){
                j--;
                if (i >= j){
                    break;
                }
            }
            if (i >= j){
                break;
            }else{
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        return new String(array);
    }

    public static void main(String[] args) {
        new D_917().reverseOnlyLetters("7_28]");
    }
}
