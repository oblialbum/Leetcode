package com.fengtin.LeetCode;

public class D_38 {
    public String countAndSay(int n) {
        String[] ans;
        if(n == 1){
            return "1";
        }
        else {
             ans = new String[n+1];
        }
        ans[1] = "1";
        StringBuffer sb = new StringBuffer();
        int count = 1;
        /**
         * 最后一位数字还需要单独处理。
         */
        for(int i = 2;i <= n;i++){
            for(int j = 0;j < ans[i - 1].length() - 1;j++){
                if(ans[i - 1].charAt(j) == ans[i - 1].charAt(j+1)){
                    count++;
                }
                else{
                    sb.append(count);
                    sb.append(ans[i - 1].charAt(j));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(ans[i - 1].charAt(ans[i-1].length() - 1));
            ans[i] = sb.toString();
            sb.setLength(0);
            count = 1;
        }
        return ans[n];
    }
}
