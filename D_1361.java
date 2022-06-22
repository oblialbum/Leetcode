package com.fengtin.LeetCode;

public class D_1361 {
    /**
     * 有向无环图，入度最大为1，出度最大为2。
     * @param n
     * @param leftChild
     * @param rightChild
     * @return
     */
    boolean[] visited;
    int cnt = 0;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        int left ,right,num0 = 0,idx = -1;
        for (int i = 0; i < n; i++) {
            left = leftChild[i];
            right = rightChild[i];
            if(left != -1){
                outDegree[i]++;
                inDegree[left]++;
            }
            if(right != -1){
                outDegree[i]++;
                inDegree[right]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if(inDegree[i] > 1 || outDegree[i] > 2){
                return false;
            }
            if(inDegree[i] == 0){
                num0++;
                idx = i;
            }
        }
        if(num0 != 1){
            return false;
        }
        visited = new boolean[n];
        return dfs(idx,leftChild,rightChild) && cnt == n;
    }

    private boolean dfs(int node,int[] left,int[] right){
        if(node == -1){
            return true;
        }
        if(visited[node]){
            return false;
        }
        visited[node] = true;
        cnt++;
        if(!dfs(left[node],left,right)){
            return false;
        }
        if(!dfs(right[node],left,right)){
            return false;
        }
        return true;
    }
}
