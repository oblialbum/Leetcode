package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_842 {
    /**
     * 算了，不优化了。24%，13%。
     * @param num
     * @return
     */
    public static List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans = new ArrayList<Integer>();
        /**
         * (0,i),(i,j)分别指代第一，第二个斐波拉契数。
         */
        for (int i = 1; i <= num.length(); i++) {
            if(!isvalid(num,0,i)){
                break;
            }
            for (int j = i + 1; j < num.length(); j++) {
                if(!isvalid(num,i,j)){
                    break;
                }
                ans.add(Integer.parseInt(num.substring(0,i)));
                ans.add(Integer.parseInt(num.substring(i,j)));
                if (dfs(0, i, j, j + 1, ans, num)) {
                    return ans;
                }
                ans.clear();
            }
        }
        return ans;
    }

    private static boolean dfs(int begin, int first, int second, int third, List<Integer> ans, String num) {
        if (third == num.length() + 1) {
            return true;
        }
        for (int i = third; i <= num.length(); i++) {
            int i1 = Integer.parseInt(num.substring(begin, first));
            int i2 = Integer.parseInt(num.substring(first, second));
            long i3 = Long.parseLong(num.substring(second, i));
            if(i3 > Integer.MAX_VALUE){
                break;
            }
            if (i3 == i1 + i2) {
                ans.add((int)i3);
                if (dfs(first, second, i, i + 1, ans, num)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }

    private static boolean isvalid(String s,int begin,int end){
        if(end - begin > 1){
            if((s.charAt(begin) =='0')){
                return false;
            }
        }
        long i = Long.parseLong(s.substring(begin, end));
        return !(i >Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        System.out.println(splitIntoFibonacci("123456579"));
    }
}
