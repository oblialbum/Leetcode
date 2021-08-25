package com.fengtin.LeetCode;

import com.fengtin.hello.idea.stack;

/**
 * @author 王鑫
 */
public class D_739 {
    private int index;
    private int data;

    public D_739(int index, int data) {
        this.index = index;
        this.data = data;
    }

    /**
     * 计算得到需要过几天才能比当前的温度高，比如今天温度21，明天22.对应输出就是1.
     *
     * @param temperatures
     * @return
     */
    private static int[] calculateDays(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        stack<D_739> stack = new stack<>();
        for (int i = 0; i < n; ) {
            if (!stack.isEmpty() && temperatures[i] > stack.peek().data) {
                int j = stack.pop().index;
                result[j] = i - j;
                continue;
            } else {
                stack.push(new D_739(i, temperatures[i]));
            }
            i++;
        }
        return result;
    }

    public static void main(String args[]) {
        int[] print = calculateDays(new int[]{-1, -2, 0, 3});
        for (int i = 0; i < print.length; i++)
            System.out.print(print[i] + " ");
    }
}
