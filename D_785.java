package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_785 {
    /**
     * 判断是否是一个二分图，每条边的节点分别存在俩个集合中。
     */
    Set<Integer> setA = new HashSet<>();
    Set<Integer> setB = new HashSet<>();
    public boolean isBipartite(int[][] graph) {
        for(int i = 0;i < graph.length;i++){
            if(!setA.contains(i) && !setB.contains(i)){
                if(!dfs(graph,i,1)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int pos,int set) {
        if(set == 1){
            setA.add(pos);
        }
        else{
            setB.add(pos);
        }
        int next = set == 1 ? 2:1;
        for (int neighbor: graph[pos]
             ) {
            if(!setA.contains(neighbor) && !setB.contains(neighbor)){
                if(!dfs(graph,neighbor,next)){
                    return false;
                }
            }
            else{
                if(setA.contains(pos) && setA.contains(neighbor)){
                    return false;
                }
                if(setB.contains(pos) && setB.contains(neighbor)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        new D_785().isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}});
    }
}
