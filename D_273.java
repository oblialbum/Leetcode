package com.fengtin.LeetCode;

public class D_273 {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        if(num < 10){
            return singles[num];
        }
        if(num < 20){
            return teens[num - 10];
        }
        String ans = "",temp = "";
        for(int i = 1;num != 0;i++){
            temp = get(num % 1000);
            num /= 1000;
            if (!"".equals(temp)) {
                temp += thousands[i - 1] + " ";
            }
            ans = temp + ans;
        }
        int count = 0;
        for(int i = ans.length()-1; i>=0;i--){
            if(ans.charAt(i) == ' '){
                count++;
            }
            else{
                break;
            }
        }
        return ans.substring(0,ans.length() - count);
    }

    private String get(int num) {
        if(num == 0){
            return "";
        }
        String res = "";
        if(num >= 100){
            res += singles[num / 100] + " "+ "Hundred" + " ";
            num %= 100;
        }
        if(num == 0){
            return res;
        }
        if(num >= 20) {
            res += tens[num / 10] + " ";
            num %= 10;
            if (num != 0) {
                res += singles[num % 10] + " ";
            }
        }
        else {
            if (num < 10) {
                res += singles[num];
            } else {
                res += teens[num - 10];
            }
            res += " ";
        }
        return res;
    }

    public static void main(String[] args){
        new D_273().numberToWords(1000000);
    }
}
