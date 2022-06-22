package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {
    /**
     * topVoted:记录第i次投票时领先的候选人。
     */
    int[] topVoted;
    int[] times;
    Map<Integer,Integer> map;
    public TopVotedCandidate(int[] persons, int[] times) {
        int max = -1;
        topVoted = new int[persons.length];
        this.times = Arrays.copyOf(times,times.length);
        map = new HashMap<>();
        map.put(-1,-1);
        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            map.put(p,map.getOrDefault(p,0)+1);
            if(map.get(p) >= map.get(max)){
                max = p;
            }
            topVoted[i] = max;
        }
    }

    public int q(int t) {
        int left = 0,right = times.length - 1,index = -1;
        if(t >= times[times.length - 1]){
            index = times.length - 1;
        }
        else {
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (times[mid] < t) {
                    if (mid < times.length - 1 && times[mid + 1] > t) {
                        index = mid;
                        break;
                    }
                    left = mid + 1;
                }
                if (times[mid] == t) {
                    index = mid;
                    break;
                }
                if (times[mid] > t) {
                    if (mid > 0 && times[mid - 1] <= t) {
                        index = mid - 1;
                        break;
                    }
                    right = mid - 1;
                }
            }
        }
        return topVoted[index];
    }

    public static void main(String[] args) {
        TopVotedCandidate candidate = new TopVotedCandidate(new int[]{0,1,1,0,0,1,0},new int[]{0,5,10,15,20,25,30});
        candidate.q(12);
    }
}
