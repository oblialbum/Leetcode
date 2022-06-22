package com.fengtin.LeetCode;

import java.util.*;

public class D_1424 {
    int[] dirX = new int[]{1,0};
    int[] dirY = new int[]{0,1};
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> list = new ArrayList<>();
        Set<Point> set = new HashSet<>();
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0,0));
        set.add(new Point(0,0));
        list.add(nums.get(0).get(0));
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                int x = cur.x;
                int y = cur.y;
                for (int j = 0; j < 2; j++) {
                    int newX = x + dirX[j];
                    int newY = y + dirY[j];
                    if (inArea(nums,newX,newY) && !set.contains(new Point(newX,newY))){
                        Point temp = new Point(newX,newY);
                        queue.offer(temp);
                        set.add(temp);
                        list.add(nums.get(newX).get(newY));
                    }
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private boolean inArea(List<List<Integer>> nums, int row, int col) {
        return row < nums.size() && col < nums.get(row).size();
    }

    private class Point{
        public int x;
        public int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode(){
            return x * 13 + y * 17;
        }
        @Override
        public boolean equals(Object o){
            if (null == o){
                return false;
            }
            if (o == this){
                return true;
            }
            if (o.getClass() == this.getClass()){
                Point p = (Point) o;
                return p.x == this.x && p.y == this.y;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i = 1; i < 7; i++) {
            list.get(0).add(i);
        }
        new D_1424().findDiagonalOrder(list);
    }
}
