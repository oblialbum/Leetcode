package com.fengtin.LeetCode;

public class W_268 {
    public int maxDistance(int[] colors) {
        int ans = 0,n = colors.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(colors[i] != colors[j]){
                    ans = Math.max(ans,Math.abs(j - i ));
                }
            }
        }
        return ans;
    }

    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0,n = plants.length,curCapacity = capacity;
        for (int i = 0; i < n; i++) {
            if(curCapacity >= plants[i]){
                ans += 1;
                curCapacity -= plants[i];
            }
            else{
                curCapacity = capacity;
                ans += (i + i);
                i--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new W_268().wateringPlants(new int[]{1,1,1,4,2,3},4);
    }
}
