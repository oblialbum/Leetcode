package com.fengtin.LeetCode;

public class W_292 {
    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                sb.append(i);
            }
            if (num.contains(sb.toString())){
                return sb.toString();
            }
        }
        return "";
    }
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    //返回{节点数，sum,avg}
    private int[] dfs(TreeNode root) {
        if (root == null){
            return new int[]{0,0,0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int sum = l[1] + r[1] + root.val,nodeNum = l[0] + r[0] + 1;
        int avg = sum / nodeNum;
        if (avg == root.val){
            res++;
        }
        return new int[]{nodeNum,sum,avg};
    }

    static long  mod = (long) (1e9 +7);
    static long[] dp3 = new long[100001];
    static long[] dp4 = new long[100001];
    static {
        dp3[0] = 1;
        dp4[0] = 1;
        dp3[1] = 1;
        dp4[1] = 1;
        dp3[2] = 2;
        dp4[2] = 2;
        dp3[3] = 4;
        dp4[3] = 4;
        for (int i = 4; i < 100001; i++) {
            dp3[i] = dp3[i - 1] + dp3[i - 2] + dp3[i - 3];
            dp4[i] = dp4[i - 1] + dp4[i - 2] + dp4[i - 3] + dp4[i - 4];
            dp3[i] %= mod;
            dp4[i] %= mod;
        }
    }
    public int countTexts(String pressedKeys) {
        long cnt = 1;
        int left = 0, right = 0,n = pressedKeys.length();
        while (right < n){
            while (right < n && pressedKeys.charAt(right) == pressedKeys.charAt(left)){
                right++;
            }
            if (pressedKeys.charAt(left) == '7' || pressedKeys.charAt(left) == '9'){
                cnt *= dp4[right - left];
                cnt %= mod;
            }else{
                cnt *= dp3[right - left];
                cnt %= mod;
            }
            if (right != n){
                left = right;
            }
        }
        return (int)cnt;
    }
    char[][] grid ;
    int m,n;
    boolean[][][] state;
    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        if (grid[m- 1][n - 1] != ')' || m + n - 1 % 2 == 1 || grid[0][0] != '('){
            return false;
        }
        state = new boolean[m][n][m + n];
        return DFS(0,0,0);
    }

    private boolean DFS(int row, int col, int c) {
        if (c > (m - row + n - col - 1)){
            return false;
        }
        if (state[row][col][c]){
            return false;
        }
        if (row == m - 1 && col == n - 1 ){
            return c == 1;
        }
        state[row][col][c] = true;
        c += grid[row][col] == '(' ? 1 :-1;
        return c >= 0 && (row < m - 1 && DFS(row + 1,col,c) ||col < n - 1 && DFS(row,col +1,c));
    }
}
