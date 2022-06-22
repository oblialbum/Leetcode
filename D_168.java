package com.fengtin.LeetCode;

public class D_168 {
    /**
     * 不是26进制吗？就是啊。从1开始，一直到26，没有0.
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while(columnNumber > 0){
            int curNum = columnNumber % 26;
            if(curNum == 0){
                sb.append('Z');
                columnNumber -= 26;
            }
            else{
                sb.append((char)('A'+curNum - 1));
                columnNumber -= curNum;
            }
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        new D_168().convertToTitle(701);
        int ans = 0;
        String s = "FXSHRXW";
        for(int i = 0;i < s.length();i++){
            ans += (s.charAt(i) - 'A' + 1) * Math.pow(26,s.length() - i - 1);
        }
        System.out.println(ans);
    }
}
