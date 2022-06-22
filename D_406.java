package com.fengtin.LeetCode;

public class D_406 {
    int n, p = 0;
    int[][] ans;
    int[] modify;

    public static void main(String[] args) {
        new D_406().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }

    public int[][] reconstructQueue(int[][] people) {
        n = people.length;
        ans = new int[n][2];
        modify = new int[n];
        boolean[] visited = new boolean[n];
        reconstructQueue(people, visited);
        return ans;
    }

    private void reconstructQueue(int[][] people, boolean[] visited) {
        int index = -1, minHeight = -1, minK = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (index == -1) {
                index = i;
                minHeight = people[i][0];
                minK = people[i][1];
            } else {
                if (people[i][1] < minK) {
                    minK = people[i][1];
                    index = i;
                    minHeight = people[i][0];
                } else if (people[i][1] == minK && people[i][0] < minHeight) {
                    minHeight = people[i][0];
                    index = i;
                }
            }
        }
        if (index == -1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (people[i][0] <= minHeight && i != index) {
                modify[i] += 1;
                people[i][1] -= 1;
            }
        }
        visited[index] = true;
        ans[p][0] = people[index][0];
        ans[p][1] = people[index][1] + modify[index];
        p++;
        reconstructQueue(people, visited);
    }
}
