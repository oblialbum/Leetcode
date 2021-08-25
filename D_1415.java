package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_1415 {
    char[] c = new char[]{'a', 'b', 'c'};
    List<String> ans = new ArrayList();
    int num;

    public static void main(String[] args) {
        D_1415 obj = new D_1415();
        System.out.println(obj.getHappyString(10, 4));
        for (int i = 0; i < obj.ans.size(); i++) {
            System.out.println(i + ":" + obj.ans.get(i));
        }
    }

    public String getHappyString(int n, int k) {
        num = k;
        dfs('z', n, new StringBuilder());
        return num > 0 ? "" : ans.get(k - 1);
    }

    /**
     * 只需要生成K个字符串即可。
     *
     * @param n
     * @param sb
     */
    private boolean dfs(char pre, int n, StringBuilder sb) {
        if (n == 0) {
            ans.add(sb.toString());
            num--;
            return num == 0;
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] != pre) {
                sb.append(c[i]);
                if (dfs(c[i],n - 1, sb)) {
                    return true;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}
