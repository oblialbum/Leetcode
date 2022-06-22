package com.fengtin.LeetCode;

public class D_440 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0){
            long cnts = dfs(cur,cur,n);
            //第K个数在当前的节点下方。
            if (cnts <= k){
                 k -= cnts;
                 cur++;
            }else{
                k--;
                cur *= 10;
            }
        }
        return cur;
    }

    /**
     * 从l到r的下一层有多少个节点。
     * @param l
     * @param r
     * @param n
     * @return
     */
    private long dfs(long l, long r, int n) {
        if (l > n){
            return 0;
        }
        return Math.min(r,n) - l + 1 + dfs(l * 10,r*10 + 9,n);
    }

}
