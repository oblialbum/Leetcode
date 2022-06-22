package com.fengtin.LeetCode;

public class D_1401 {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        if(x_center >= x1 && x_center <= x2){
            if(y_center >= y1 - radius && y_center <= y2 + radius){
                return true;
            }
        }
        if(x_center >= x1 - radius && x_center <= x2 + radius){
            if(y_center >= y1 && y_center <= y2){
                return true;
            }
        }
        double left_top_dist = Math.pow(x_center - x1,2) + Math.pow(y_center - y2,2);
        double left_bottom_dist = Math.pow(x_center - x1,2) + Math.pow(y_center - y1,2);
        double right_top_dist = Math.pow(x_center - x2,2) + Math.pow(y_center - y2,2);
        double right_bottom_dist = Math.pow(x_center - x2,2) + Math.pow(y_center - y1,2);
        int max_dist = radius * radius;
        return max_dist >= left_bottom_dist || max_dist >= left_top_dist || max_dist >= right_bottom_dist || max_dist >= right_top_dist;
    }

    public static void main(String[] args){
        new D_1401().checkOverlap(1,0,3,7,3,10,6);
    }
}
