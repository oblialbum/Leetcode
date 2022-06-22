package com.fengtin.LeetCode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    private volatile int start = 1;

    private volatile int state;
    private Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (state != 0) {
                    zero.await();
                }
                printNumber.accept(0);
                if (start % 2 == 0) {
                    state = 2;
                    even.signal();
                } else {
                    state = 1;
                    odd.signal();
                }
                zero.await();
            }
            //不唤醒，有一个线程会始终处于等待状态，无法结束。
            odd.signal();
            even.signal();
        } finally {
            lock.unlock();
        }
    }

    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (state != 2) {
                    even.await();
                } else {
                    printNumber.accept(start++);
                    state = 0;
                    zero.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    //基数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (state != 1) {
                    odd.await();
                } else {
                    printNumber.accept(start++);
                    state = 0;
                    zero.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero((x)->{System.out.print(x);});
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even((x)->{System.out.print(x);});
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");

        Thread t3 = new Thread(()->{
            try {
                zeroEvenOdd.odd((x)->{System.out.print(x);});
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t3");
        t1.start();
        t2.start();
        t3.start();

    }
}
