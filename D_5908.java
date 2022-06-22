package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D_5908 {
    Map<Integer,int[]> map = new HashMap<>();
    int n ;
    /**
     * 叶节点不存储在该map中。
     */
    Map<Integer, List<Integer>> child = new HashMap<>();
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        for (int i = 1;i < n;i++){
            List<Integer> temp = child.getOrDefault(parents[i],new ArrayList<Integer>());
            temp.add(i);
            child.put(parents[i],temp);
        }
        dfs(0);
        long max = 0;
        int count = 0;
        for(int i = 0;i < n;i ++){
            long score = remove(i);
            if(score > max ){
                max = score;
                count = 1;
            }
            else if(score == max){
                count++;
            }
        }
        return count;
    }

    /**
     * 返回该节点所包含的节点数目。
     * @param node
     * @return
     */
    private int dfs(int node) {
        if(node == -1){
            return  -1;
        }
        if(!child.containsKey(node)){
            map.put(node,new int[]{0,0});
            return 0;
        }
        List<Integer> children = child.get(node);
        int left = children.get(0),right = -1;
        if(children.size() == 2){
            right = children.get(1);
        }
        left = dfs(left) + 1;
        right = dfs(right) + 1;
        map.put(node,new int[]{left,right});
        return left + right;
    }

    private long remove(int node) {
        if(!child.containsKey(node)){
            return n - 1;
        }
        if(child.get(node).size() == 1){
            int origin = n - map.get(node)[0] - 1;
            int left = map.get(node)[0];
            return origin == 0 ? left : (long)origin * left;
        }
        else{
            int origin = n - map.get(node)[0] - map.get(node)[1] - 1;
            int left = map.get(node)[0];
            int right = map.get(node)[1];
            return origin == 0 ? (long)left * right : (long)origin * left * right;
        }
    }


    public static void main(String[] args){
        new D_5908().countHighestScoreNodes(new int[]{-1,2,0});
    }
}
