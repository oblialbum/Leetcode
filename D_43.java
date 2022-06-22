package com.fengtin.LeetCode;

public class D_43 {
    public String multiply(String num1, String num2) {
        if(num1.length() == 1 && num1.charAt(0) == '0'){
            return "0";
        }
        if(num2.length() == 1 && num2.charAt(0) == '0'){
            return "0";
        }
        char[] ans = new char[num1.length()  + num2.length()];
        for(int i = 0;i < ans.length;i++){
            ans[i] = '0';
        }
        /**
         *    456
         *  * 123
         */
        for(int i = num1.length() - 1; i >= 0;i--){
            int first = num1.charAt(i) - '0';
            for(int j = num2.length() - 1;j >= 0;j--){
                int sum = first * (num2.charAt(j) -'0');
                //int replaceIndex = ans.length - 1 - (num2.length() - 1 - j) - (num1.length() - 1 - i);
                int replaceIndex = i + j + 1;
                sum += (ans[replaceIndex] -'0');
                ans[replaceIndex] = (char) ('0' + sum % 10);
                ans[replaceIndex - 1] = (char)(sum /10 + '0');

            }
        }
        int begin = 0;
        for(;ans[begin] == '0';begin++){

        }
        return new String(ans,begin,ans.length - begin);
    }

    public static void main(String[] args){
       System.out.println( new D_43().multiply("15","42"));
    }
}
