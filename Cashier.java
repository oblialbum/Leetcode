package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Cashier {
    double discount;
    int n ,cur = 0;
    Map<Integer,Integer> map ;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        map = new HashMap<>();
        this.n = n;
        this.discount = discount;
        for (int i = 0; i < products.length; i++) {
            map.put(products[i],prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        int originBill = 0;
        for (int i = 0; i < product.length; i++) {
            originBill += map.get(product[i]) * amount[i];
        }
        if(cur == n - 1){
            cur = 0;
            return originBill * (1 - discount / 100);
        }
        cur++;
        return originBill;
    }
}
