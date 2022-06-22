package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockPrice {
    class Stock{
        int time;
        int price;
    }
    List<Stock> list = new ArrayList<Stock>();
    Map<Integer, Stock> map = new HashMap<>();
    int cur;
    public StockPrice() {
        cur = 0;
    }

    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            Stock stock = map.get(timestamp);
            stock.price = price;
            //调整位置。
            list.remove(stock);
            insert(stock);
        }
        else{
            if(timestamp > cur){
                cur = timestamp;
            }
            Stock stock = new Stock();
            stock.price = price;
            stock.time =  timestamp;
            map.put(timestamp,stock);
            insert(stock);
            //插入新的股票。
        }
    }

    private void insert(Stock stock) {
        int left = 0,right = list.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid).price < stock.price){
                left = mid + 1;
            }
            if(list.get(mid).price > stock.price){
                right = mid - 1;
            }
            if(list.get(mid).price == stock.price){
                list.add(mid,stock);
                return;
            }
        }
        list.add(left,stock);
    }

    public int current() {
        return map.get(cur).price;
    }

    public int maximum() {
        return list.get(list.size() - 1).price;
    }

    public int minimum() {
        return list.get(0).price;
    }

    public static void main(String[] args){
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        stockPrice.current();     // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
        stockPrice.maximum();     // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
        stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
        // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
        stockPrice.maximum();     // 返回 5 ，更正后最高价格为 5 。
        stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        stockPrice.minimum();     // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
    }
}
