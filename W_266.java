package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class W_266 {
    public int countVowelSubstrings(String word) {
        int ans = 0;
        for (int i = 0; i < word.length() - 1; i++) {
            for(int j = i + 1;j <= word.length();j++){
                if(judge(word.substring(i,j))){
                    ans++;
                }
            }
        }
        return ans;
    }
    private boolean judge(String s){
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()
             ) {
            if(c == 'a'){
                set.add(c);
            }
            else if(c == 'e'){
                set.add(c);
            }
            else if(c == 'i'){
                set.add(c);
            }
            else if(c == 'o'){
                set.add(c);
            }
            else if(c == 'u'){
                set.add(c);
            }
            else{
                return false;
            }
        }
        return set.size() == 5;
    }

    /**
     * 不需要DP，没啥用。
     * sum:
     * @param word
     * @return
     */
    public long countVowels(String word) {
        int n = word.length();
        long sum;
        int[] DP = new int[n];
        DP[0] = judgeYuanYin(word.charAt(0)) ? 1 : 0;
        sum = DP[0];
        for (int i = 1; i < n; i++) {
            DP[i] = DP[i - 1] + (judgeYuanYin(word.charAt(i)) ? 1 : 0);
            sum += DP[i];
        }
        long ans = sum;
        for (int i = 1; i < n; i++) {
            sum -= (n + 1 - i) * (judgeYuanYin(word.charAt(i - 1)) ? 1 : 0);
            ans += sum;
        }
        return ans;
    }
    private boolean judgeYuanYin(Character c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }


    public int minimizedMaximum(int n, int[] quantities) {
        int l = 0,r = 100005;
        while(l < r){
            int mid = l + (r-l) / 2;
            int count = 0;
            for (int quantity: quantities
                 ) {
                count += (quantity - 1)/mid + 1;
            }
            if(count <= n){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }


    public static void main(String[] args){
        new W_266().minimizedMaximum(22,new int[]{25,11,29,6,24,4,29,18,6,13,25,30});
    }
}
