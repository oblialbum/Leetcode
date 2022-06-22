package com.fengtin.LeetCode;

public class D_427 {
    public Node construct(int[][] grid) {
        ///暴力解决，复杂度够。
        return dfs(grid,0,0,grid.length,grid.length);
    }
    //[begin,end)
    private Node dfs(int[][] grid, int begin_x,int begin_y, int end_x,int end_y) {
        Node root = new Node();
        root.isLeaf = judge(grid,begin_x,begin_y,end_x,end_y);
        root.val = grid[begin_x][begin_y] == 1;
        if (!root.isLeaf){
            root.topLeft = dfs(grid,begin_x,begin_y,(end_x + begin_x) /2,(end_y + begin_y) /2);
            root.topRight = dfs(grid,begin_x,(end_y + begin_y) /2,(end_x + begin_x) /2,end_y);
            root.bottomLeft = dfs(grid,(end_x + begin_x) /2,begin_y,end_x,(end_y + begin_y) /2);
            root.bottomRight = dfs(grid,(end_x + begin_x) /2,(end_y + begin_y) /2,end_x,end_y);
        }
        return root;
    }

    private boolean judge(int[][] grid, int begin_x,int begin_y,int end_x, int end_y) {
        if (end_x == begin_x + 1){
            return true;
        }
        int val = grid[begin_x][begin_y];
        for (int i = begin_x; i < end_x; i++) {
            for (int j = begin_y; j < end_y; j++) {
                if (grid[i][j] != val){
                    return false;
                }
            }
        }
        return true;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };

    public static void main(String[] args) {
        Node node = new D_427().construct(new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}
        ,{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0}
        ,{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}});
        System.out.println(node);
    }
}
