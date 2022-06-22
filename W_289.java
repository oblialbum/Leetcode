package com.fengtin.LeetCode;

import java.util.*;

public class W_289 {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[nums[0].length];
        for (int[] num:nums
             ) {
            Arrays.sort(num);
        }

            for (int i = 0; i < nums[0].length; i++) {
                boolean flag = true;
                for (int j = 1; j < nums.length; j++) {
                    if (Arrays.binarySearch(nums[j],nums[0][i]) < 0){
                        flag = false;
                        break;
                    }
                }
                visited[i] = flag;
                if (visited[i]){
                    res.add(nums[0][i]);
                }
            }

        return res;
    }

    /**
     * 数据范围 ->枚举所有点判断是否在一个⚪内。
     * @param circles
     * @return
     */
    public int countLatticePoints(int[][] circles) {
        int res = 0;
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                if (inCircle(i,j,circles)){
                    res++;
                }
            }
        }
        return res;
    }

    private boolean inCircle(int x, int y, int[][] circles) {
        boolean flag = false;
        int distance ;
        for (int[] circle: circles
             ) {
            distance = (int) (Math.pow(x-circle[0],2) + Math.pow(y - circle[1],2));
            if (distance <= circle[2] * circle[2]){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int n = points.length;
        int[] res = new int[n];
        Arrays.sort(rectangles, (x,y)-> x[1] == y[1] ? x[0] - y[0] :x[1] - y[1]);
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        for (int[] rectangle:rectangles
             ) {
            map.putIfAbsent(rectangle[1],new ArrayList<>());
            map.get(rectangle[1]).add(rectangle[0]);
        }
        for (int i = 0; i < n; i++) {
            Integer key = map.ceilingKey(points[i][1]);
            if (key == null){
                continue;
            }
            int idx = search(map.get(key),points[i][0]);
            if (idx != -1){
                res[i] += map.get(key).size() - idx;
            }
            while (map.higherKey(key) != null){
                key = map.higherKey(key);
                idx = search(map.get(key),points[i][0]);
                if (idx != -1){
                    res[i] += map.get(key).size() - idx;
                }
            }
        }
        return res;
    }

    /**
     * 返回第一个》target的下标，不存在则返回-1；
     * @param list
     * @param target
     * @return
     */
    private int search(List<Integer> list, int target) {
        int n = list.size();
        if (list.get(n - 1) < target){
            return -1;
        }
        int left = 0,right = n- 1;
        while (left < right){
            int mid = (left + right) >> 1;
            if (list.get(mid) < target){
                left = mid + 1;
            }
            if (list.get(mid) >= target){
                right = mid;
            }
        }
        return left;
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n = persons.length;
        int[] res = new int[n];


        return res;
    }

    public static void main(String[] args) {
        new W_289().countRectangles(new int[][]{{6,4},{10,2},{5,5},{1,6},{3,2},{9,5},{7,6}},new int[][]{{2,1},{2,8},{8,4},{10,8},{5,6},{1,4},{2,4},{2,2},{6,10}});
    }
}
