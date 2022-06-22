package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class W_78 {
    public int divisorSubstrings(int num, int k) {
        String ori = String.valueOf(num);
        int res = 0,n = ori.length();
        for (int i = 0; i <= n - k; i++) {
            if (qwer(ori.substring(i,i+k),num)){
                res++;
            }
        }
        return res;
    }

    private boolean qwer(String substring, int num) {
        int temp = Integer.parseInt(substring);
        if (temp == 0){
            return false;
        }
        return num - (num / temp * temp) == 0;
    }

    public int waysToSplitArray(int[] nums) {
        int res = 0,n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] >= prefix[n - 1] - prefix[i]){
                res++;
            }
        }
        return res;
    }
    //错了。
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int res = 0, n = tiles.length;
        Arrays.sort(tiles, Comparator.comparingInt(x -> x[0]));
        int len = 0;
        for (int i = 0; i < n; i++) {
            len = Math.max(len,tiles[i][1] - tiles[i][0]);
        }
        if (len >= carpetLen){
            return carpetLen;
        }
        len = 0;
        int[] copy = new int[2*n-1];
        copy[2*n - 2] = tiles[n - 1][1] - tiles[n - 1][0]+1;
        for (int i = 0; i < n - 1; i++) {
            copy[2 * i] = tiles[i][1] - tiles[i][0]+1;
            copy[2 * i + 1] = tiles[i+1][0] - tiles[i][1] - 1;
        }
        int begin = 0,cur=0;
        for (int i = 0; i < 2*n-1; i++) {
            len += copy[i];
            cur += (i % 2 == 0 ? copy[i] :0);
            if (len < carpetLen){
                res = Math.max(res,cur);
                continue;
            }
            if (i % 2 == 1){
                res = Math.max(res,cur);
                while (len >= carpetLen) {
                    len -= copy[begin];
                    cur -= begin % 2 == 0 ?  copy[begin]:0;
                    begin ++;
                }
            }else{
                if (len == carpetLen){
                    res = Math.max(res,cur);
                }else{
                    res = Math.max(res,cur - (len - carpetLen));
                }
                while (len >= carpetLen) {
                    len -= copy[begin];
                    cur -= begin % 2 == 0 ?  copy[begin]:0;
                    begin ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new W_78().maximumWhiteTiles(new int[][]{{8051,8057},{8074,8089},{7994,7995},{7969,7987},{8013,8020},{8123,8139},{7930,7950},{8096,8104},{7917,7925},{8027,8035},{8003,8011}},9857);
    }
}
