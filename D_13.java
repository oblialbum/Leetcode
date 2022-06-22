package com.fengtin.LeetCode;

public class D_13 {
    /**
     * I,V,X,L,C,D,M
     * IV,IX,XL,XC,CD,CM
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int ans = 0;
        for(int i = 0;i < s.length(); i++){
            char c = s.charAt(i);
            if(c =='I'){
                if(i < s.length()-1){
                    if(s.charAt(i + 1) =='V'){
                        ans += 4;
                        i++;
                        continue;
                    }
                    if(s.charAt(i + 1) =='X'){
                        ans += 9;
                        i++;
                        continue;
                    }
                }
                ans += 1;
            }
            if(c =='V'){
                ans += 5;
            }
            if(c =='X'){
                if(i < s.length()-1){
                    if(s.charAt(i + 1) =='L'){
                        ans += 40;
                        i++;
                        continue;
                    }
                    if(s.charAt(i + 1) =='C'){
                        ans += 90;
                        i++;
                        continue;
                    }
                }
                ans += 10;
            }
            if(c =='L'){
                ans += 50;
            }
            if(c =='C'){
                if(i < s.length()-1){
                    if(s.charAt(i + 1) =='D'){
                        ans += 400;
                        i++;
                        continue;
                    }
                    if(s.charAt(i + 1) =='M'){
                        ans += 900;
                        i++;
                        continue;
                    }
                }
                ans += 100;
            }
            if(c =='D'){
                ans += 500;
            }
            if(c =='M'){
                ans += 1000;
            }
        }
        return ans;
    }
}
