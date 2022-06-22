package com.fengtin.LeetCode;

import java.util.*;

public class D_1992 {
    public int[][] findFarmland(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        int[] xDir = new int[]{1,0};
        int[] yDir = new int[]{0,1};
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0 || visited[i][j]){
                    continue;
                }
                int[] cur = new int[4];
                cur[0] = i;
                cur[1] = j;
                queue.offer(new int[]{i,j});
                visited[i][j] = true;
                while (!queue.isEmpty()){
                    int[] pos = queue.poll();
                    cur[2] = pos[0];
                    cur[3] = pos[1];
                    for (int k = 0; k < 2; k++) {
                        int newX = pos[0] + xDir[k];
                        int newY = pos[1] + yDir[k];
                        if (newX >= 0 && newX < land.length && newY >= 0 && newY < land[0].length){
                            if (land[newX][newY] == 0 || visited[newX][newY]){
                                continue;
                            }
                            queue.offer(new int[]{newX,newY});
                            visited[newX][newY] = true;
                        }
                    }
                }
                list.add(cur);
            }
        }
        if (list.isEmpty()){
            return new int[][]{};
        }
        int[][] res = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        new D_1992().findFarmland(new int[][]{{1,0,0},{0,1,1},{0,1,1}});
    }
}
