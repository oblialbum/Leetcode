package com.fengtin.LeetCode;

public class FooBar {
    private int n;
    private volatile boolean fooRun = true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (fooRun){
                printFoo.run();
                fooRun = false;
                i++;
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n;) {
            if (!fooRun){
                printBar.run();
                fooRun = true;
                i++;
            }
            // printBar.run() outputs "bar". Do not change or remove this line.

        }
    }
}
