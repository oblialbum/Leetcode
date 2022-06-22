package com.fengtin.LeetCode;

public class D_796 {
    public boolean rotateString(String s, String goal) {
        if (s.equals(goal)){
            return true;
        }
        if (s.length() != goal.length()){
            return false;
        }
        int[] num = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            num[s.charAt(i) -'a']++;
            num[goal.charAt(i) -'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (num[i] != 0){
                return false;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if (sb.toString().equals(goal)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new D_796().rotateString("bqqutquvbtgouklsayfvzewpnrbwfcdmwctusunasdbpbmhnvy",
                "wpnrbwfcdmwctusunasdbpbmhnvybqqutquvbtgouklsayfvze");
    }
}
