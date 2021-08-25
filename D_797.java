package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_797 {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList();
        int n = graph.length;
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        dfs(0,n,graph,ans,list);
        return ans;
    }

    /**
     *可以使用stack来代替list,快1ms。
     * 有向无环图，所以无需记录节点元素是否被访问过。
     * @param pos 当前正在处理的节点
     * @param n 总结点个数0-->N-1
     * @param graph
     * @param answer
     * @param list
     */
    private static void dfs(int pos,int n,int[][] graph,List<List<Integer>> answer,List list){
        if(pos == graph.length - 1){
            answer.add(new ArrayList(list));
            return;
        }
        for(int i = 0;i < graph[pos].length;i++){
            list.add(graph[pos][i]);
            dfs(graph[pos][i],n,graph,answer,list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        int[][] graph = new int[][]{{1,2,3},{2},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }
}
