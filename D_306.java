package com.fengtin.LeetCode;

public class D_306 {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int secondStart = 1; secondStart < n - 1; secondStart++) {
            if (num.charAt(0) == '0' && secondStart != 1){
                break;
            }
            for (int secondEnd = secondStart; secondEnd < n - 1; secondEnd++) {
                if (num.charAt(secondStart) == '0' && secondEnd != secondStart){
                    break;
                }
                if(vaild(secondStart,secondEnd,num)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean vaild(int secondStart, int secondEnd, String num) {
        int n = num.length();
        int firstStart = 0,firstEnd = secondStart - 1;
        while (secondEnd <= n- 1){
            String third = stringAdd(firstStart,firstEnd,secondStart,secondEnd,num);
            int thirdStart = secondEnd + 1,thirdEnd = secondEnd + third.length();
            if (thirdEnd >= n || !num.substring(thirdStart,thirdEnd + 1).equals(third)){
                return false;
            }
            if (thirdEnd == n - 1){
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    /**
     * 恶心，需要从后往前跌打计算third，之后还要reverse，直接copy把。
     * @param firstStart
     * @param firstEnd
     * @param secondStart
     * @param secondEnd
     * @param s
     * @return
     */
    private String stringAdd(int firstStart, int firstEnd, int secondStart, int secondEnd,String s) {
        StringBuffer third = new StringBuffer();
        int carry = 0, cur = 0;
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
            cur = carry;
            if (firstEnd >= firstStart) {
                cur += s.charAt(firstEnd) - '0';
                --firstEnd;
            }
            if (secondEnd >= secondStart) {
                cur += s.charAt(secondEnd) - '0';
                --secondEnd;
            }
            carry = cur / 10;
            cur %= 10;
            third.append((char) (cur + '0'));
        }
        third.reverse();
        return third.toString();
    }
}
