package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_638 {
    int n ;
    int ans = Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        n = price.size();
        dfs(price,special,needs,0);
        return ans;
    }

    private void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int sum) {
        if(sum >= ans){
            return;
        }
        for(int i = 0;i < special.size();i++){
            if(isEnough(needs,special.get(i))){
                for (int j = 0;j < n;j++){
                    int val = needs.get(j);
                    val -=special.get(i).get(j);
                    needs.set(j,val);
                }
                sum += special.get(i).get(n);

                dfs(price,special,needs,sum);

                sum -= special.get(i).get(n);
                for (int j = 0;j < n;j++){
                    int val = needs.get(j);
                    val +=special.get(i).get(j);
                    needs.set(j,val);
                }
            }
        }
        for(int i = 0;i < n;i ++){
            sum += needs.get(i) * price.get(i);
        }
        ans = Math.min(sum,ans);
    }

    private boolean isEnough(List<Integer> needs, List<Integer> special) {
        for(int i = 0;i < n;i++){
            if(needs.get(i) < special.get(i)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        List<Integer> price = new ArrayList<>();
        List<List<Integer>> specials = new ArrayList<>();
        List<Integer> needs = new ArrayList<>();
        int[] p = new int[]{5};
        int[][] s = new int[][]{{1,3},{4,7},{3,3}};
        int[] n = new int[]{4};
        for(int i = 0;i < p.length;i++){
            price.add(p[i]);
            needs.add(n[i]);
        }
        for(int i = 0;i < s.length;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j < s[0].length;j++){
                   list.add(s[i][j]);
            }
            specials.add(list);
        }
        System.out.println(new D_638().shoppingOffers(price,specials,needs));
    }
}
