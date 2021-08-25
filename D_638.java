package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class D_638 {
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int[] sum = new int[2];
        for(int i = 0;i < price.size();i++){
            sum[1] += price.get(i) * needs.get(i);
        }
        HashMap<List<Integer>, Integer> hash = new HashMap();
        dfs(price.size(),price,special,needs,sum,new int[needs.size()]);
        return sum[1];
    }

    /**
     *
     * @param n
     * @param price
     * @param special
     * @param needs
     * @param sum sum[0]为当前和（初始化为0）,sum[1]为最小和。
     * @param current
     */
    private static void dfs(int n,List<Integer> price, List<List<Integer>> special, List<Integer> needs,int[] sum,int[] current){

        for(int i = 0;i < special.size();i++){
            if(isEnough(needs,special,current,i)){

                { System.out.print("添加了第"+i+"个大礼包："+special.get(i)+" current:[");
                for(int j = 0;j < current.length;j++){
                    System.out.print(current[j]+" ");
                }
                System.out.println("] needs:"+needs);
                 }

                sum[0] += special.get(i).get(n);
                dfs(n,price,special,needs,sum,current);
                sum[0] -= special.get(i).get(n);
                removeSpecial(needs,special,current,i);

                System.out.println("回溯："+"删除添加的第"+i+"个大礼包："+special.get(i)+" current:[");
                for(int j = 0;j < current.length;j++){
                    System.out.print(current[j]+" ");
                }
                System.out.println("] needs:"+needs);

            }
        }
        /**
         * 大礼包有不同组合，单品只有一种选择。
         */
        int temp = 0;
        for(int i = 0;i < n;i++){
            if(current[i] == needs.get(i)){
                continue;
            }
             temp += price.get(i) * (needs.get(i)- current[i]);
        }
        sum[0] += temp;
        if(sum[0] < sum[1]){
            sum[1] = sum[0];
            System.out.println("sum:"+sum[1]);
        }
        sum[0] -= temp;
        return;
    }

    /**
     *
     * @param needs
     * @param special
     * @param pos 代表当前正在处理第pos个大礼包
     * @return
     */
    private static boolean isEnough(List<Integer> needs,List<List<Integer>> special,int[] current,int pos){
        /**
         * 验证是否可以添加大礼包
         */
        for(int i = 0;i < needs.size();i++) {
            if (needs.get(i) < special.get(pos).get(i) + current[i]) {
                return false;
            }
        }
        /**
         * 添加大礼包。
         */
        for(int i = 0;i < needs.size();i++){
            current[i] += special.get(pos).get(i);
        }
        return true;
    }
    private static void removeSpecial(List<Integer> needs,List<List<Integer>> special,int[] current,int pos){
        for(int i = 0;i < needs.size();i++){
            current[i] -= special.get(pos).get(i);
        }
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
        System.out.println(shoppingOffers(price,specials,needs));
    }
}
