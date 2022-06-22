package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        /**
         * 初始化杨辉三角，将一二行结果加入列表。
         */
        list.add(1);
        ans.add(new ArrayList<>(list));
        if(numRows == 1){
            return ans;
        }
        list.add(1);
        ans.add(new ArrayList<>(list));

        for(int i = 3;i <= numRows; i++){
            List<Integer> List = ans.get(i - 1 - 1);
            List<Integer> ilist = new ArrayList<>();
            ilist.add(1);
            for(int j = 0;j < List.size() - 1;j++){
                ilist.add(List.get(j) + List.get(j + 1));
            }
            ilist.add(1);
            ans.add(new ArrayList<>(ilist));
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(new D_118().generate(5));
    }
}
