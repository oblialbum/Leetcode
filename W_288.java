package com.fengtin.LeetCode;

import java.util.PriorityQueue;

public class W_288 {
    public int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] % 2 == arr[j] % 2 && arr[i] < arr[j]){
                    char c = arr[i];
                    arr[i] = arr[j];
                    arr[j] = c;
                }
            }
        }
        return Integer.valueOf(String.valueOf(arr));
    }
    
    int idx = 0;
    public String minimizeResult(String expression) {
        idx = expression.indexOf('+');
        int n = expression.length();
        char[] arr = expression.toCharArray();
        // [0,idx - 1],在下标前方插入   应该不允许在+左右插入括号。
        //[idx + 1,n-1]，在下标后方插入
        int res = Integer.MAX_VALUE,resI = -1,resJ = -1;
        for (int i = 0; i < idx; i++) {
            for (int j = idx + 1; j < n; j++) {
                int temp = cal(arr,i,j);
                if (temp < res){
                    res = temp;
                    resI = i;
                    resJ = j;
                }
            }
        }
        if (resI == -1) {
            return expression;
        }
        StringBuilder sb = new StringBuilder(expression);
        sb.insert(resI,'(');
        sb.insert(resJ + 2,')');
        return sb.toString();
    }

    private int cal(char[] arr, int left, int right) {
        int first = 1,second = 1;
        if (left != 0) {
            first = Integer.parseInt(String.valueOf(arr).substring(0, left));
        }
        if (right != arr.length- 1) {
            second = Integer.parseInt(String.valueOf(arr).substring(right + 1));
        }

        int mid = Integer.parseInt(String.valueOf(arr).substring(left ,idx));
        mid += Integer.parseInt(String.valueOf(arr).substring(idx + 1 ,right + 1));
        return mid * first * second;
    }

    /**
     * analysis:a*b*c*d*e,每次增加1，必定会导致结果增大，0的情况除外。
     * 一定是K次之后得到最大结果。
     * (a+1)*b*c*d*e --> bcde -->让最小的数字增加1
     * O:num(O) >= k res = 0;num(0)< k,先加0，再加其他的最小数。
     *      先加最小数，加完K次求积。
     * @param nums
     * @param k
     * @return
     */
    public int maximumProduct(int[] nums, int k) {
        final int mod = (int) (1e9 +7);
        PriorityQueue<Long> min = new PriorityQueue<>();
        for (int num:nums
             ) {
            min.add((long) num);
        }
        while (k > 0){
            min.add(min.poll() + 1);
            k--;
        }
        long res = 1;
        while (!min.isEmpty()){
            res *= min.poll();
            res %= mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        new W_288().largestInteger(247);
    }
}
