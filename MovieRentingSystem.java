package com.fengtin.LeetCode;

import java.util.*;

public class MovieRentingSystem {
    /**
     * pq是小顶堆，但是遍历的时候无序。
     */
    private class shopPrice implements Comparable<shopPrice> {
        int shop;
        int price;
        public shopPrice(int shop,int price){
            this.shop = shop;
            this.price = price;
        }
        @Override
        public int compareTo(MovieRentingSystem.shopPrice o) {
            return this.price - o.price == 0 ? this.shop - o.shop: this.price - o.price;
        }
    }
    PriorityQueue<int[]> rented = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[2] - o2[2] == 0 ? o1[1] - o2[1]:o1[2] - o2[2];
        }
    });
    Map<Integer,List<shopPrice> > exist = new HashMap<>();
    Map<Integer,HashMap<Integer,Integer>> all = new HashMap<>();
    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entrie:entries
             ) {
            List<shopPrice> list = exist.getOrDefault(entrie[1],new ArrayList<>());
            list.add(new shopPrice(entrie[0],entrie[2]));
            exist.put(entrie[1],list);
            Map<Integer,Integer> map = all.getOrDefault(entrie[1],new HashMap<>());
            map.put(entrie[0],entrie[2]);
            all.put(entrie[1],(HashMap<Integer, Integer>) map);
        }
    }

    public List<Integer> search(int movie) {
        List<shopPrice> ans = exist.getOrDefault(movie,new ArrayList<>());
        Collections.sort(ans);
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < ans.size();i++){
            res.add(ans.get(i).shop);
            if(res.size() == 5){
                return res;
            }
        }
        return res;
    }

    public void rent(int shop, int movie) {
        List<shopPrice> ans = exist.getOrDefault(movie,new ArrayList<shopPrice>());
        int price = 0;
        for(int i = 0;i < ans.size();i++){
            if(ans.get(i).shop == shop){
                price = ans.get(i).price;
                ans.remove(i);
                break;
            }
        }
        rented.add(new int[]{shop,movie,price});
    }

    public void drop(int shop, int movie) {
        int price = all.get(movie).get(shop);
        for (int[] entry: rented
             ) {
            if(entry[0] == shop && entry[1] == movie && entry[2] == price){
                rented.remove(entry);
                break;
            }
        }
        List<shopPrice> ans = exist.getOrDefault(movie,new ArrayList<>());
        ans.add(new shopPrice(shop,price));
    }

    public List<List<Integer>> report() {
        int count = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (!rented.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int[] temp = rented.poll();
            for(int i = 0;i < temp.length;i++){
                list.add(temp[i]);
            }
            count++;
            if(count == 5){
                break;
            }
        }
        for (List<Integer> list: ans
             ) {
            rented.add(new int[]{list.get(0),list.get(1),list.get(2)});
            list.remove(2);
        }
        return ans;
    }

}
