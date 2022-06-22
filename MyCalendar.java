package com.fengtin.LeetCode;

import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer,Integer> map ;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    /**
     * 可以成功加入的情况：
     * 左边最接近的日程结束时间 <= start
     * 右边最接近的日程开始时间>= end
     * @param start
     * @param end
     * @return
     */
    public boolean book(int start, int end) {
        Integer pre = map.floorKey(start),next = map.ceilingKey(start);
        if ((pre == null || map.get(pre) <= start) && (next == null || end <= next)) {
            map.put(start,end);
            return true;
        }
        return false;
    }


}
