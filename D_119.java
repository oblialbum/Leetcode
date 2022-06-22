package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        /**
         * 初始化杨辉三角，将一二行结果加入列表。
         */
        list.add(1);
        if(rowIndex == 0){
            return list;
        }
        list.add(1);
        List<Integer> nextList = list;
        for(int i = 3;i <= rowIndex + 1; i++){
            nextList = new ArrayList<>();
            nextList.add(1);
            for(int j = 0;j < list.size() - 1;j++){
                nextList.add(list.get(j) + list.get(j + 1));
            }
            nextList.add(1);
            list = nextList;
        }
        return nextList;
    }

    public static void main(String[] args){
        System.out.println(new D_119().getRow(1));
    }
}
