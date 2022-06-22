package com.fengtin.LeetCode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class D_365 {
    /*
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity + jug2Capacity < targetCapacity){
            return false;
        }
        if(jug1Capacity < jug2Capacity){
            int temp = jug1Capacity;
            jug1Capacity = jug2Capacity;
            jug2Capacity = temp;
        }
        if(jug1Capacity == jug2Capacity){
            return targetCapacity == 2 * jug1Capacity;
        }
        boolean[][] visited = new boolean[jug1Capacity + 1][jug2Capacity + 1];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if(cur[0] == 0){
                    cur[0] += jug1Capacity;
                    // 0,0 --> x,0
                    if(!visited[cur[0]][cur[1]]) {
                        queue.offer(new int[]{cur[0], cur[1]});
                        visited[cur[0]][cur[1]] = true;
                    }
                    //0,0 --> 0,y
                    if(!visited[0][jug2Capacity]) {
                        queue.offer(new int[]{0, jug2Capacity});
                        visited[0][jug2Capacity] = true;
                    }
                    //0,? -->
                    if(cur[1] != 0){
                        int origin = cur[1];
                        //0,y --> x,y  0,y --> x,y-x;
                        if(origin > jug1Capacity){
                            if(!visited[jug1Capacity][origin]){
                                queue.offer(new int[]{jug1Capacity,origin});
                                visited[jug1Capacity][origin] = true;
                            }
                            if(!visited[jug1Capacity][origin - jug1Capacity]){
                                queue.offer(new int[]{jug1Capacity,origin-jug1Capacity});
                                visited[jug1Capacity][origin - jug1Capacity] = true;
                            }
                            if(!visited[jug1Capacity][0]){
                                queue.offer(new int[]{jug1Capacity,0});
                                visited[jug1Capacity][0] = true;
                            }

                        }
                        else{
                            if(!visited[origin][0]){
                                queue.offer(new int[]{origin,0});
                                visited[origin][0] = true;
                            }
                        }
                    }
                }
                else{
                    if(cur[1] == 0){
                        if(!visited[cur[0]][jug2Capacity]){
                            queue.offer(new int[]{cur[0],jug2Capacity});
                            visited[cur[0]][jug2Capacity] = true;
                        }

                    }
                }
            }
        }
    }
    */
    public boolean canMeasureWater(int x, int y, int z) {
        Deque<int[]> stack = new LinkedList<>();
        stack.push(new int[]{0, 0});
        Set<Long> seen = new HashSet<>();
        while (!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));

            int[] state = stack.pop();
            int remainX = state[0], remainY = state[1];
            if (remainX == z || remainY == z || remainX + remainY == z) {
                return true;
            }
            // 把 X 壶灌满。
            stack.push(new int[]{x, remainY});
            // 把 Y 壶灌满。
            stack.push(new int[]{remainX, y});
            // 把 X 壶倒空。
            stack.push(new int[]{0, remainY});
            // 把 Y 壶倒空。
            stack.push(new int[]{remainX, 0});
            // 把 X 壶的水灌进 Y 壶，直至灌满或倒空。
            stack.push(new int[]{remainX - Math.min(remainX, y - remainY), remainY + Math.min(remainX, y - remainY)});
            // 把 Y 壶的水灌进 X 壶，直至灌满或倒空。
            stack.push(new int[]{remainX + Math.min(remainY, x - remainX), remainY - Math.min(remainY, x - remainX)});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }
}
