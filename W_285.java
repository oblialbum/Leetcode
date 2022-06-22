package com.fengtin.LeetCode;

import java.util.Arrays;

public class W_285 {
    public int countHillValley(int[] nums) {
        int res = 0,n = nums.length;
        int[] neighborLeft = new int[n];
        int[] neighborRight = new int[n];
        for (int i = 1; i < n - 1; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if (nums[j] < nums[i]){
                    neighborLeft[i] = 1;
                    break;
                }
                if (nums[j] > nums[i]){
                    neighborLeft[i] = -1;
                    break;
                }
            }
            for (int j = i + 1; j < n ; j++) {
                if (nums[j] < nums[i]){
                    neighborRight[i] = 1;
                    break;
                }
                if (nums[j] > nums[i]){
                    neighborRight[i] = -1;
                    break;
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (neighborLeft[i] * neighborRight[i] == 1){
                if (nums[i - 1] == nums[i]){
                    continue;
                }
                res++;
            }
        }
        return res;
    }
    char[] arr;
    public int countCollisions(String directions) {
        int res = 0,n = directions.length();
        arr = directions.toCharArray();
        return dfs(arr,0);
    }

    private int dfs(char[] arr, int pos) {
        int res = 0;
        for (int i = pos; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'L'){
                if (i == 0){
                    continue;
                }
                if (arr[i - 1] == 'S'){
                    arr[i] = 'S';
                    res++;
                }
                if (arr[i - 1] == 'R'){
                    res += 2;
                    arr[i] = 'S';
                }
            }
            if (c == 'S'){
                continue;
            }
            if (c == 'R'){
                if (i == arr.length - 1){
                    continue;
                }
                if (arr[i + 1] == 'L'){
                    res += 2;
                    arr[i] = 'S';
                    arr[i + 1] = 'S';
                    continue;
                }
                if (arr[i+1] == 'S'){
                    res++;
                    arr[i] = 'S';
                }
                if (arr[i + 1] == 'R'){
                    res += dfs(arr,i+1);
                    if (arr[i + 1] == 'S'){
                        arr[i] = 'S';
                        res++;
                    }
                    if (arr[i + 1] == 'L'){
                        res += 2;
                        arr[i] = 'S';
                    }
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 12个区域，每个区域bob只有得分(0)和不得分(1)两种情况。
     * 枚举所有的情况，2^12，判断在numArrows限制的条件下能否满足该情况。
     * 计算每种情况的得分。
     * @param numArrows
     * @param aliceArrows
     * @return
     */
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] res = new int[aliceArrows.length];
        int maxScore = -1;
        for (int i = 0; i < 1 << 12; i++) {
            int cur = i,need = 0,score = 0;
            int[] state = new int[12];
            int[] curNums = new int[12];
            for (int j = 0; j < 12; j++) {
                state[j] = cur % 2;
                cur /= 2;
                if (state[j] == 1){
                    need += aliceArrows[j] + 1;
                    curNums[j] = aliceArrows[j] + 1;
                    score += j;
                }
            }
            if (need <= numArrows){
                if (score > maxScore){
                    maxScore = score;
                    res = Arrays.copyOf(curNums, 12);
                    int diff = numArrows - need;
                    if (diff == 0){
                        continue;
                    }
                    for (int j = 0; j < 12; j++) {
                        if (state[j] == 0){
                            res[j] += diff;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new W_285().maximumBobPoints(89,new int[]{3,2,28,1,7,1,16,7,3,13,3,5});
    }


}
