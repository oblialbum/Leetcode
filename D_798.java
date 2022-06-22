package com.fengtin.LeetCode;

public class D_798 {
    /**
     * 每次论调，值不变，只改变索引。且索引减小，到0的时候再减小则变为n - 1.
     * @param nums
     * @return
     */
    public int bestRotation(int[] nums) {
        int res = 0,n = nums.length,maxScore = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= i){
                maxScore++;
            }
        }
        for (int i = 1; i < n; i++) {
            int curScore = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] <= (j - i + n) % n){
                    curScore++;
                }
            }
            if (curScore > maxScore){
                maxScore = curScore;
                res = i;
            }
        }
        return res;
    }
}
