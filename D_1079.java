package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class D_1079 {
    /**
     * 求所有非空字母序列的数目。
     * 从1-n，n:字符串长度。
     * 全排列，去重。
     * @param tiles
     * @return
     */
    private static int count = 0;

    public static int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        HashSet<Character> hashSet = new HashSet<Character>();
        List<Character> key = new ArrayList<Character>();
        for(int i = 0;i < tiles.length();i++){
            if(!hashMap.containsKey(tiles.charAt(i))){
                hashMap.put(tiles.charAt(i),1);
                hashSet.add(tiles.charAt(i));
                key.add(tiles.charAt(i));
            }
            else{
                hashMap.replace(tiles.charAt(i),hashMap.get(tiles.charAt(i))+1);
            }
        }
        char[] Key = new char[key.size()];
        for(int i = 0;i < Key.length;i++){
            Key[i] = key.remove(0);
        }
        int[] num = new int[Key.length];
        for(int i = 0;i < num.length;i++){
            num[i] = hashMap.get(Key[i]);
        }
        for(int i = 1;i <= tiles.length();i++){
            dfs(Key,num,i,0,0, hashSet,new HashMap<Character,Integer>());
        }
        return count;
    }

    /**
     *
     * @param length 当前子序列的长度。
     * @param curLen    当前正在处理的字符长度。
     * @param keyList
     * @param ans 当前长度下添加完的字符情况，如A1,B2,C2.
     */
    private static void dfs(char[] key,int[] value ,int length, int curLen,int pos, HashSet<Character> keyList,HashMap<Character,Integer> ans){
        if(curLen == length){
            caculate(ans);
            return;
        }
        for(int i = pos;i < key.length;i++){
            if(value[i] > 0){
                value[i]--;
                /**
                 * 对ans进行相应处理。
                 */
                if(ans.containsKey(key[i])){
                    ans.replace(key[i],ans.get(key[i]) + 1);
                }
                else{
                    ans.put(key[i],1);
                }

                dfs(key,value,length,curLen+1,i,keyList,ans);

                value[i]++;
                ans.replace(key[i],ans.get(key[i]) - 1);
            }
        }
    }

    private static void caculate(HashMap<Character,Integer> map){
        int sum1 = 0;
        int sum2 = 1;
        for (char c: map.keySet()
             ) {
                sum2 *= factorial(map.get(c));
                sum1 += map.get(c);
        }
        count += factorial(sum1)/sum2;
        //遍历了俩次AB。
    }

    private static int factorial(int n){
        if(n == 1||n == 0){
            return 1;
        }
        return  factorial(n-1) * n;
    }
    public static void main(String[] args){
        numTilePossibilities("AAABBC");
        System.out.println(count);
    }
}
