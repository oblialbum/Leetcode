package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class W_259 {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String s: operations
             ) {
            if(s.equals("++X") || s.equals("X++")){
                ans++;
            }
            else{
                ans--;
            }
        }
        return ans;
    }

    /**
     * 定义前缀最大，后缀最小DP。
     * @param nums
     * @return
     */
    public int sumOfBeauties(int[] nums) {
        int ans = 0;
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1;i < nums.length;i++){
            dpMax[i] = Math.max(dpMax[i - 1],nums[i]);
            dpMin[nums.length - 1 - i] = Math.min(dpMin[nums.length - i],nums[nums.length - 1 - i]);
        }
        for(int i = 1;i < nums.length - 1;i++){
            if(nums[i] < dpMin[i + 1] && nums[i] > dpMax[i - 1]){
                ans += 2;
            }
            else if(nums[i] < nums[i + 1] && nums[i] > nums[i - 1]){
                ans += 1;
            }
        }
    return  ans;
    }

    /**
     * 面积为正：不能自己与自己连。
     * 怎么存储呢？hash.
     * point内部记录斜率为1，-1时的常量C，代表在哪一条直线上。
     * 先找对角线上的点，不能时自己，俩条对角线。
     * 对角线上的点（非本身），可能会有多个重复点。
     */
    static class DetectSquares {
        private  class Point {
            int x;
            int y;
            int c1,c2;
            public Point(int[] point){
                this.x = point[0];
                this.y = point[1];
                c1 = y - x;
                c2 = y + x;
            }
            @Override
            public boolean equals(Object o){
                if(o == this){
                    return true;
                }
                if(o instanceof Point){
                    if(((Point)o).y == this.y && ((Point)o).x == this.x){
                        return true;
                    }
                }
                return false;
            }

            @Override
            public int hashCode(){
                return x+y;
            }
        }
        private Map<Point,Integer> map ;
        private int count;
        public DetectSquares() {
            map = new HashMap<Point,Integer>();
        }

        /**
         * y - x = c,同一C的点在同一条斜率为1的直线上，用来下一步detectSquare.
         * 还有一条对角线，斜率为-1.
         * 用MAP存储，相同点，地址不同。
         * @param point
         */
        public void add(int[] point) {
            Point p = new Point(point);
            if(map.containsKey(p)){
                map.replace(p,map.get(p) + 1);
            }
            else{
                map.put(p,1);
            }
        }

        public int count(int[] point) {
            count = 0;
            int c1 = point[1] - point[0];
            int c2 = point[1] + point[0];
            for (Point p: map.keySet()
                 ) {
                if(p.c1 == c1 || p.c2 == c2){
                    /**
                     * 判断这个点是否和查询的点重复，重复不处理。
                     */
                    if(!(p.x == point[0] && p.y == point[1])){
                        /**
                         * 寻找另外俩个点。
                         */
                        count += map.get(p) * detectTwoPoint(p.x,point[1],point[0],p.y);
                    }
                }
            }
            return count;
        }

        private int detectTwoPoint(int firstX, int firstY, int secondX, int secondY) {
            Point first = new Point(new int[]{firstX,firstY});
            Point second = new Point(new int[]{secondX,secondY});
            return map.getOrDefault(first,0) * map.getOrDefault(second,0);
        }
    }

    public static void main(String[] args){
        W_259.DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3,10});
        detectSquares.add(new int[]{11,2});
        detectSquares.add(new int[]{3,2});
        detectSquares.count(new int[]{11,10});
        detectSquares.count(new int[]{14,8});
        detectSquares.add(new int[]{11,2});
        detectSquares.count(new int[]{11,10});
    }
}
