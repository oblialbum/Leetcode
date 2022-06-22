package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_2049 {
    int n ,cnt = 0;
    long res = 0;
    List<List<Integer>> list ;
    int[] left ,right;
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        left = new int[n];
        right = new int[n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            list.get(parents[i]).add(i);
        }
        dfs(0);
        return cnt;
    }

    /**
     * 返回当前以当前节点为根节点的树的节点数。
     * @param node
     * @return
     */
    private int dfs(int node) {
        if (list.get(node).isEmpty()){
            left[node] = 0;
            right[node] = 0;
            if(n - 1 > res){
                res = n -1;
                cnt = 1;
            }else if (n - 1  == res){
                cnt++;
            }
            return 1;
        }
        left[node] = dfs(list.get(node).get(0));
        right[node] = list.get(node).size() > 1 ?dfs(list.get(node).get(1)):0;
        int num = 1 + left[node] + right[node];
        long score = (long)(n == num ? 1 : n - num) * (long)left[node] * (long)(right[node] == 0 ? 1 :right[node]);
        if (score > res){
            res = score;
            cnt = 1;
        }else if (score == res){
            cnt++;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new D_2049().countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}));
    }
}
