package com.fengtin.LeetCode;

import java.util.*;

public class W_269 {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                list.add(i);
            }
            if(nums[i] > target){
                break;
            }
        }
        return list;
    }

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length,begin = 0,end = 2 * k;
        long sum = 0L;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        if(n < 2 * k + 1){
            return ans;
        }
        for (int i = 0; i < k && i < n; i++) {
            sum += nums[i];
            sum += nums[2 * k - i];
        }
        sum += nums[k];
        ans[k] = (int)(sum / (2 * k + 1));
        for (; end < n - 1; ) {
            sum += nums[++end];
            sum -= nums[begin++];
            ans[end - k] = (int)(sum / (2 * k + 1));
        }
        return ans;
    }

    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1 || n == 2){
            return n;
        }
        int min = 0,max = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] > nums[max]){
                max = i;
            }
            if(nums[i] < nums[min]){
                min = i;
            }
        }
        int left = Math.max(min,max) + 1;
        int right = n -  Math.min(min,max);
        if(min > max){
            int temp = min;
            min = max;
            max = temp;
        }
        int leftAndRight = min + 1 + n - max;
        return Math.min(left,Math.min(right,leftAndRight));
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UnionFind uf = new UnionFind(n);
        uf.union(0,firstPerson);
        Arrays.sort(meetings, (o1, o2) -> o1[2] - o2[2]);
        int m = meetings.length;
        for (int i = 0; i < m; i++) {
            int times = meetings[i][2];
            Set<Integer> set = new HashSet<>();
            while (true){
                int[] meeting = meetings[i];
                set.add(meeting[0]);
                set.add(meeting[1]);
                if(uf.isConnected(meeting[0],0) || uf.isConnected(meeting[1],0)){
                    uf.union(meeting[0],0);
                    uf.union(meeting[1],0);
                }
                else{
                    uf.union(meeting[0],meeting[1]);
                }
                if(i + 1 < m && meetings[i + 1][2] == times){
                    i++;
                }
                else {
                    break;
                }
            }

            for (int key: set
                 ) {
                if(!uf.isConnected(key,0)){
                    uf.split(key);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            if(uf.isConnected(0,i)){
                list.add(i);
            }
        }
        return list;
    }

}
