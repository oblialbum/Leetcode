package com.fengtin.LeetCode;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.*;

public class W_72 {
    public int countPairs(int[] nums, int k) {
        int n = nums.length,res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] == nums[j] && i * j % k == 0){
                    res++;
                }
            }
        }
        return res;
    }

    public long[] sumOfThree(long num) {
        if (num % 3 != 0){
            return new long[]{};
        }
        long mid = num / 3;
        return new long[]{mid - 1,mid,mid + 1};
    }

    List<Long> res = new ArrayList<>();
    Set<Long> set = new HashSet<>();
    int max = 0;

    /**
     * 拆分为N个不同的偶整数，使得N最大。
     * finalNumber /2 ，拆分为N个不同的数，使得N最大。
     * 1+2+3+N = (N % N+1 )/2
     * @param finalSum
     * @return
     */
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0){
            return res;
        }
        finalSum /= 2;
        long cur = 0;
        long i = 1;
        while (cur < finalSum){
            cur += i;
            res.add((long) i);
            i++;
        }
        if (cur == finalSum){
            for (int j = res.size() - 1;j >=0 ; j--) {
                res.set(j,res.get(j) * 2);
            }
            return res;
        }
        cur -= (i - 1);
        long diff = finalSum - cur;
        res.remove(res.size() - 1);
        for (int j = res.size() - 1; j >= 0 ; j--) {
            if (diff > 0) {
                res.set(j, res.get(j) * 2 + 2);
                diff--;
            }else{
                res.set(j, res.get(j) * 2);
            }
        }
        return res;
    }



    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                System.out.println(num.getAndIncrement());
            },"t"+i).start();
        }
        num.updateAndGet(x -> x * 10 + 3);
        AtomicReference<BigDecimal> balance = new AtomicReference<>();
        AtomicStampedReference<BigDecimal> balance2 = new AtomicStampedReference<BigDecimal>(new BigDecimal(3),2);
        balance.getAndUpdate((BigDecimal x)->{
            balance.get().multiply(x);
            return balance.get();
        });
        new AtomicIntegerArray(10);
        LongAdder adder = new LongAdder();
        System.out.println(num);
    }
}
