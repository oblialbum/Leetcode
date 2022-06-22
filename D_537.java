package com.fengtin.LeetCode;

public class D_537 {
    public String complexNumberMultiply(String num1, String num2) {
        int index1 = num1.indexOf('+'),index2 = num2.indexOf('+');
        int a1 = Integer.valueOf(num1.substring(0,index1)),b1 = Integer.valueOf(num1.substring(index1 + 1,num1.length() - 1));
        int a2 = Integer.valueOf(num2.substring(0,index2)),b2 = Integer.valueOf(num2.substring(index2 + 1,num2.length() - 1));
        int a = a1 * a2,b =a1 * b2 +a2 * b1;
        a -= b1*b2;
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append('+');
        sb.append(b);
        sb.append('i');
        return sb.toString();
    }

    public static void main(String[] args) {
        new D_537().complexNumberMultiply("1+-1i","0+0i");
    }
}
