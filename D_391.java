package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_391 {
    /**
     1。统计小矩形面积，更新左下右上四个值（左下找最小，右上找最大）；
     2。把每次遍历到的矩形四点坐标放入set中，重复的就去除；
     3。观察set中是否剩下四个坐标，并且四个坐标是满足左下右上四个值组合起来的；
     4.3满足且大小矩形面积相等返回true，不满足返回false。
     * @param rectangles
     * @return
     */
    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        if(n == 1){
            return true;
        }
        Set<Point> set = new HashSet<>();
        long area = 0;
        int left = rectangles[0][0];
        int right = rectangles[0][2];
        int low = rectangles[0][1];
        int high = rectangles[0][3];
        for (int[] rectangle:rectangles
             ) {
            int x = rectangle[0],y = rectangle[1],a = rectangle[2],b = rectangle[3];
            left = Math.min(left,x);
            right = Math.max(right,a);
            low = Math.min(low,y);
            high = Math.max(high,b);
            area += (a - x) * (b - y);

            Point p1 = new Point(x,y);
            Point p2 = new Point(a,y);
            Point p3 = new Point(x,b);
            Point p4 = new Point(a,b);

            if(set.contains(p1)){
                set.remove(p1);
            }
            else{
                set.add(p1);
            }
            if(set.contains(p2)){
                set.remove(p2);
            }
            else{
                set.add(p2);
            }
            if(set.contains(p3)){
                set.remove(p3);
            }
            else{
                set.add(p3);
            }
            if(set.contains(p4)){
                set.remove(p4);
            }
            else{
                set.add(p4);
            }
        }
        if(set.size() != 4||area != (long)(right - left) * (high - low)||!set.contains(new Point(left,low))||!set.contains(new Point(right,low))||!set.contains(new Point(left,high))||!set.contains(new Point(right,high))){
            return false;
        }
        return true;
    }

    private class Point {
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Point)){
                return false;
            }
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return x *137 + y;
        }
    }

    public static void main(String[] args){
        new D_391().isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}});
    }
}
