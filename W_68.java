package com.fengtin.LeetCode;

import java.util.*;

public class W_68 {
    public int mostWordsFound(String[] sentences) {
        int max = 1;
        for (String sentence: sentences
             ) {
            max = Math.max(max,getWords(sentence));
        }
        return max;
    }

    private int getWords(String sentence) {
        int res = 1;
        for (char c: sentence.toCharArray()
             ) {
            if (c == ' '){
                res++;
            }
        }
        return res;
    }

    Set<String> set ;
    Map<String,HashSet<String>> map;
    Map<String,Integer> idx;
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        int[] inDegree = new int[n];
        List<String> res = new ArrayList<>();
        set = new HashSet<>();
        map = new HashMap<>();
        idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idx.put(recipes[i],i);
        }
        for (String supply:supplies
             ) {
            set.add(supply);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                String need = ingredients.get(i).get(j);
                if (!set.contains(need)){
                    HashSet<String> orDefault = map.getOrDefault(need, new HashSet<>());
                    orDefault.add(recipes[i]);
                    map.put(need,orDefault);
                    inDegree[i]++;
                }
            }
        }
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0){
                queue.offer(recipes[i]);
            }
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String recipy = queue.poll();
                res.add(recipy);
                for (String next:map.getOrDefault(recipy,new HashSet<>())
                     ) {
                    int index = idx.get(next);
                    inDegree[index]--;
                    if (inDegree[index] == 0){
                        queue.offer(next);
                    }
                }
            }
        }
        System.out.println(map);
        System.out.println(Arrays.toString(inDegree));
        return res;
    }


}
