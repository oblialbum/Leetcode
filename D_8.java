package com.fengtin.LeetCode;

public class D_8 {
    double ans;
    int symbol = 1;

    /**
     * 以非数字或+-开头应该被舍弃。
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        int index = getSymbol(s);
        if(index == -1){
            return 0;
        }
        if(!Character.isDigit(s.charAt(index))){
            index++;
        }
        for(int i = index;i < s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                break;
            }
            ans *= 10;
            ans += s.charAt(i) - '0';
        }
        ans *= symbol;
        ans = ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : ans;
        ans = ans < Integer.MIN_VALUE ? Integer.MIN_VALUE : ans;
        return (int) ans;
    }

    private int getSymbol(String s) {
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) == ' '){
                continue;
            }
            else if(s.charAt(i) == '-' || s.charAt(i) == '+' || (s.charAt(i) <= '9' && s.charAt(i) >= '0')){
                if(s.charAt(i) =='-'){
                    symbol = -1;
                }
                return i;
            }
            else{
                return -1;
            }
        }
        return -1;
    }
}
