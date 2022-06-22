package com.fengtin.LeetCode;

public class D_1093 {
    /**
     * 至少有一个样本。
     *
     * @param count
     * @return
     */
    public double[] sampleStats(int[] count) {
        double min = -1, max = -1, avg, mid = 0, mode = 0, sum = 0, num = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (min == -1) {
                min = i;
            } else {
                max = i;
            }
            if(count[(int) mode] < count[i]){
                mode = i;
            }
            sum += count[i] * i;
            num += count[i];
        }
        avg = sum / num;
        int cur = 0;
        for(int i = 0;i < count.length; i++){
            if(count[i] == 0){
                continue;
            }
            cur += count[i];
            if(num % 2 == 1){
                if(cur >= (int)(num / 2 + 1)){
                    mid = i;
                    break;
                }
            }
            if(num % 2 == 0){
                if(cur == (num / 2)){
                    for(int j = i + 1;j < count.length;j++){
                        if(count[j] != 0){
                            mid = i + j;
                            mid /= 2;
                            break;
                        }
                    }
                }
                if(cur > (num / 2)){
                    mid = i;
                    break;
                }
            }
        }
        return new double[]{min, max, avg, mid, mode};
    }

    public static void main(String[] args){
        new D_1093().sampleStats(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    }
}
