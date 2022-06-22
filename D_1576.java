package com.fengtin.LeetCode;

public class D_1576 {
    public String modifyString(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '?'){
                change(c,i);
            }
        }
        return String.valueOf(c);
    }

    private void change(char[] c, int idx) {
        char res =  'a';
        if (idx == 0){
            if (c.length == 1){
                c[idx] = res;
                return;
            }
            for (int i = 0; i < 26; i++) {
                res += i;
                if (res != c[idx + 1]){
                    break;
                }
            }
        }else{
            if (idx == c.length - 1){
                for (int i = 0; i < 26; i++) {
                    res += i;
                    if (res != c[idx - 1]){
                        break;
                    }
                }
            }else{
                for (int i = 0; i < 26; i++) {
                    res += i;
                    if (res != c[idx - 1] && res != c[idx + 1]){
                        break;
                    }
                }
            }
        }
        c[idx] = res;
    }
}
