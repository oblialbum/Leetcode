package com.fengtin.LeetCode;

public class D_223 {
    /**
     * 默认传输参数表示的矩形是正常的。
     * @param ax1 左下X坐标
     * @param ay1 左下Y坐标
     * @param ax2 右上X坐标
     * @param ay2 右上Y坐标。
     * @param bx1
     * @param by1
     * @param bx2
     * @param by2
     * @return
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = 0;
        area += (ax2 - ax1) * (ay2 - ay1);
        area += (bx2 - bx1) * (by2 - by1);
        //计算重叠面积。
        int overLapArea;
        /**
         * 不相交情况。
         * 考虑一下也可以转化为下面那种情况。
         */
        if(ax2 <= bx1 || ax1 >= bx2){
            return area;
        }
        if(ay2 <= by1 || ay1 >= by2){
            return area;
        }

        int width, height;
        width = Math.min(ax2,bx2) - Math.max(ax1,bx1);
        height = Math.min(ay2,by2) - Math.max(ay1,by1);
        overLapArea = width * height;
        return area - overLapArea;
    }
}
