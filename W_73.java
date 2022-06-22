package com.fengtin.LeetCode;

import java.util.*;

public class W_73 {
    public int mostFrequent(int[] nums, int key) {
        int n = nums.length,max = -1,res = -1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == key){
                map.put(nums[i + 1],map.getOrDefault(nums[i + 1],0) + 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {
            if (entry.getValue() > max){
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    int[] mapFun;
    public int[] sortJumbled(int[] mapping, int[] nums) {
        mapFun = mapping;
        int n = nums.length;
        int[] res = new int[n];
        nummap[] maps = new nummap[n];

        for (int i = 0; i < n; i++) {
            maps[i] = new nummap(nums[i],i);
        }
        Arrays.sort(maps,(x,y) ->(x.map == y .map ? x.idx - y.idx:x.map - y.map));
        for (int i = 0; i < n; i++) {
            res[i] = maps[i].num;
        }
        return res;
    }

    private class nummap{
        private int num;
        private int idx;
        private int map;
        public nummap(int num,int idx){
            this.num = num;
            this.idx = idx;
            this.map = map(num);
        }

        private int map(int x) {
            if (x == 0){
                return mapFun[0];
            }
            char[] res = new char[getLength(x)];
            Arrays.fill(res,'0');
            int p = res.length - 1;
            while (x > 0){
                res[p--] = (char)(mapFun[x % 10] +'0');
                x /= 10;
            }
            return Integer.valueOf(new String(res));
        }

        private int getLength(int x) {
            if (x == 0){
                return 0;
            }
            int length = 0;
            while (x > 0){
                x /= 10;
                length++;
            }
            return length;
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new HashSet<>());
        }
        for (int[] edge:edges
             ) {
            res.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(res,i,visited);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            ans.get(i).addAll(res.get(i));
            Collections.sort(ans.get(i));
        }
        return ans;
    }

    private void dfs(List<Set<Integer>> res, int node, boolean[] visited) {
        if (visited[node]){
            return;
        }
        HashSet<Integer> set = new HashSet<>(res.get(node));
        Iterator itr = set.iterator();
        while (itr.hasNext()){
            int parent = (int) itr.next();
            dfs(res, parent,visited);
            res.get(node).addAll(res.get(parent));
        }
        visited[node] = true;
    }

    public static void main(String[] args) {
        new W_73().sortJumbled(new int[]{8,9,4,0,2,1,3,5,7,6},new int[]{991,338,38});
    }
}
