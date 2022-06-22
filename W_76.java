package com.fengtin.LeetCode;

import java.util.Arrays;

public class W_76 {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num:nums
             ) {
            if (Math.abs(num) < min){
                min = Math.abs(num);
            }
        }
        int cur = -min;
        for (int num:nums
        ) {
            if (Math.abs(num) == min){
                min = Math.max(num,min);
            }
        }
        return cur;
    }
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        for (int i = 0; i <= total / cost1; i++) {
            int left = total - cost1 * i;
            res += left / cost2 + 1;
        }
        return res;
    }

    static class ATM {
        long[] nums,temp;
        int[] out;
        int idx;
        final int len = 5;
        public ATM() {
            nums = new long[len];
            idx = 0;
            out = new int[len];
            temp = new long[]{20,50,100,200,500};
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < len; i++) {
                nums[i] += banknotesCount[i];
                if (banknotesCount[i] != 0){
                    idx = i;
                }
            }
        }

        public int[] withdraw(int amount) {
            boolean flag = false;
            bigNum = false;
            Arrays.fill(out,0);
            flag = dfs(amount,idx);
            if (flag) {
                for (int i = 0; i < len; i++) {
                    nums[i] -= out[i];
                    if (nums[i] != 0) {
                        idx = i;
                    }
                }
            }
            return flag ? out:new int[]{-1};
        }
        boolean bigNum;
        private boolean dfs(int amount, int pos) {
            if (pos == -1){
                if (amount > 0){
                    bigNum = true;
                }
                return amount == 0;
            }
            for (long i = Math.min(nums[pos],amount/temp[pos]); i >= 0; i--) {
                out[pos] = (int) i;
                if(dfs((int) (amount - i * temp[pos]),pos - 1)){
                  return true;
                }
                if (bigNum){
                    return false;
                }
                out[pos] = 0;
            }
            return false;
        }
    }



    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0,0,1,0,1});
        atm.withdraw(100);
    }
}
