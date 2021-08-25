package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1774 {
    /**
     * 遍历N中冰淇淋，每种情况分别回溯.
     * @param baseCosts N种冰淇淋，只能选一种。
     * @param toppingCosts M种配料，任意选择，每种最多选俩次。
     * @param target    距离目标最近，多种情况选总价最小。
     * @return
     */
    int diff  = -1;
    int sum = 0;
    int count = 0;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        Arrays.sort(toppingCosts);
        for(int i = 0;i < baseCosts.length; i++){
            sum = baseCosts[i];
            dfs(0,new int[toppingCosts.length],toppingCosts,target);
        }
        return count;
    }
    private void dfs(int pos,int[] times,int[] toppingCosts,int target){
        if(diff == -1){
            diff = Math.abs(sum - target);
            count = sum;
        }
        if(Math.abs(sum - target) < diff){
            diff = Math.abs(sum - target);
            count = sum;
        }
        if(Math.abs(sum - target) == diff){
            count = sum > count ? count : sum;
        }
        for(int i = pos;i < toppingCosts.length;i++) {
            if (times[i] != 2) {
                if(Math.abs(sum + toppingCosts[i] - target) > Math.abs(sum  - target)){
                    break;
                }
                sum += toppingCosts[i];
                times[i] += 1;
                dfs(i,times,toppingCosts,target);
                sum -= toppingCosts[i];
                times[i] -= 1;
            }
        }
    }
    public static void main(String[] args){
        System.out.println(new D_1774().closestCost(new int[]{10},new int[]{1},1));
    }
}
