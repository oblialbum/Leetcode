package com.fengtin.LeetCode;

import java.util.TreeMap;

public class D_1705 {
    /**
     * [b,a],a:几个apple，b:过期时间。
     * 每次选择即将过期的apple
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        int res = 0,n = apples.length,time= 1;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            //更新今天产出的苹果，过期的苹果。
            map.put(time + days[i],map.getOrDefault(time + days[i],0) + apples[i]);
            map.remove(time);
            //选择即将过期的苹果。
            if (map.higherKey(time) != null && map.get(map.higherKey(time)) > 0){
                map.put(map.higherKey(time),map.get(map.higherKey(time)) - 1);
                if (map.get(map.higherKey(time)) == 0){
                    map.remove(map.higherKey(time));
                }
                res++;
            }
            time++;
        }
        while (map.higherKey(time) != null && map.get(map.higherKey(time)) > 0){
            int nextTime = map.higherKey(time);
            if (map.get(map.higherKey(time)) >= nextTime - time){
                res += nextTime - time;
            }
            else{
                res += map.get(map.higherKey(time));
                nextTime = time + map.get(map.higherKey(time));
            }
            map.remove(map.higherKey(time));
            time = nextTime;
        }
        return res;
    }

    public static void main(String[] args) {
        new D_1705().eatenApples(new int[]{5,2,3},new int[]{6,9,10});
    }
}
