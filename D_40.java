package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_40 {
    /**
     * 获取candidates数组中所有和为target的子集，解集不能重复，元素只能使用一次。
     * @param candidates
     * @param target
     * @return
     */
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        recursion(answer,candidates,target,new ArrayList<Integer>(),0);
        return answer;
    }

    /**
     * 正常dfs会导致重复解出现，原因是从不同位置的相同元素出发可能会导致相同的解。（位置相邻）
     * i = pos，表示当前处理的是第一个重复元素。
     * if(i > pos && candidates[i] == candidates[i-1]) {
     *                 continue;
     *             }
     * @param answer 最终答案
     * @param candidates 数据
     * @param target    目标和
     * @param list  当前解
     * @param pos   当前处理开始的位置。
     */
    private static void recursion(List<List<Integer>> answer ,int[] candidates,int target,List<Integer> list,int pos){
        if(target == 0){
            answer.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = pos;i < candidates.length;i++) {
            if(i > pos && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (target - candidates[i] >= 0) {
                list.add(candidates[i]);
                recursion(answer, candidates, target - candidates[i], list, i + 1);
                list.remove(list.lastIndexOf(candidates[i]));
            }
            else {
                break;
            }
        }
    }
    public static void main(String[] args){
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}
