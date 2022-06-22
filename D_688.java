package com.fengtin.LeetCode;

import java.util.*;


public class D_688 {
    /**
     * 记录每个位置能够到达的位置
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */
    int[] v = new int[]{-2,-2,-1,1,2,2,1,-1};
    int[] h = new int[]{-1,1,2,2,1,-1,-2,-2};
    public double knightProbability(int n, int k, int row, int column) {
        Map<Point, HashSet<Point>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                HashSet<Point> set = map.getOrDefault(new Point(i,j),new HashSet<>());
                add(set,i,j,n);
                map.put(new Point(i,j),set);
            }
        }
        double max = Math.pow(8,k);
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row,column));
        while (!queue.isEmpty() && k > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                Set<Point> set = map.getOrDefault(p,new HashSet<>());
                for (Point next:set
                     ) {
                    queue.offer(next);
                }
            }
            k--;
        }
        return queue.size() / max;
    }

    private void add(Set<Point> set, int x, int y,int n) {
        for (int i = 0; i < v.length; i++) {
            int offsetX = v[i];
            int offsetY = h[i];
            if (judge(x + offsetX,n) && judge(y+offsetY,n)){
                set.add(new Point(x + offsetX,y + offsetY));
            }
        }
    }

    private boolean judge(int x,int n) {
        return x >= 0 && x < n;
    }

    private class Point {
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 13 *x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null){
                return false;
            }
            if (obj.getClass() != getClass()){
                return false;
            }
            Point p = (Point)obj;
            return p.x == x && p.y == y;
        }
    }

    public static void main(String[] args) {
        new D_688().knightProbability(3,2,0,0);
    }
}
