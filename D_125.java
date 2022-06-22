package com.fengtin.LeetCode;

public class D_125 {
    public boolean isPalindrome(String s) {
        for(int i = 0,j = s.length() - 1;i < j;){
            if(!(Character.isLowerCase(s.charAt(i)) || Character.isUpperCase(s.charAt(i)) || Character.isDigit(s.charAt(i)))){
                i++;
                continue;
            }
            if(!(Character.isLowerCase(s.charAt(j)) || Character.isUpperCase(s.charAt(j) )|| Character.isDigit(s.charAt(j)))){
                j--;
                continue;
            }
            /**
             * 判断俩个字符是否属于俩种不同类型。
             */
            if(Character.isDigit(s.charAt(i))){
                if(Character.isLowerCase(s.charAt(j)) || Character.isUpperCase(s.charAt(j))){
                    return false;
                }
            }
            if(Character.isDigit(s.charAt(j))){
                if(Character.isLowerCase(s.charAt(i)) || Character.isUpperCase(s.charAt(i))){
                    return false;
                }
            }
            int diff = s.charAt(i) - s.charAt(j);
            if(diff != 0 && Math.abs(diff) != 32){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    public static void main(String[] args){
        new D_125().isPalindrome("0P");
    }
}
