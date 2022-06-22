package com.fengtin.LeetCode;

public class D_482 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                count++;
            }
        }
        count = s.length() - count;
        if(count == 0){
            return  new String();
        }
        int p = 0;
        int times = count / k;
        for(int i = 0;i < count % k;i++) {
            while (s.charAt(p) == '-') {
                p++;
            }
            if (Character.isLowerCase(s.charAt(p))) {
                sb.append((char)(s.charAt(p++) - 32));
            } else {
                sb.append(s.charAt(p++));
            }
        }
        if(sb.length() != 0) {
            sb.append('-');
        }
        while (times > 0) {
            for (int i = 0; i < k; i++) {
                while (s.charAt(p) == '-') {
                    p++;
                }
                if(Character.isLowerCase(s.charAt(p))) {
                    sb.append((char)(s.charAt(p++) - 32));
                } else {
                    sb.append(s.charAt(p++));
                }
            }
            sb.append('-');
            times--;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public  static void main(String[] args){
        System.out.println('A' - 'a');
        new D_482().licenseKeyFormatting("2-5g-3-J",2);
    }
}
