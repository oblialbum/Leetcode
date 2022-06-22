package com.fengtin.LeetCode;

public class Bank {
    long[] bank ;
    int size;
    public Bank(long[] balance) {
        bank = balance;
        size = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 < 0 || account1 > size){
            return false;
        }
        if(account2 < 0 || account2 > size){
            return false;
        }
        if(bank[account1 - 1] < money){
            return false;
        }
        bank[account1 - 1] -= money;
        bank[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account < 0 || account > size){
            return false;
        }
        bank[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account < 0 || account > size){
            return false;
        }
        if(bank[account - 1] < money){
            return false;
        }
        bank[account - 1] -= money;
        return true;
    }
}
