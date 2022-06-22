package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典内元素不重复。
 * 给定一个字符串，判断是否能将该字符串的一个字符改变后存在字典中。
 */
public class MagicDictionary {
    Map<Integer, ArrayList<String>> map ;
    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s: dictionary
             ) {
            List list = map.getOrDefault(s.length(),new ArrayList<String>());
            list.add(s);
            map.put(s.length(),(ArrayList)list);
        }
    }

    /**
     * 1.长度相同
     * 2.相同位置上的字符仅有一个不同.
     * @param searchWord
     * @return
     */
    public boolean search(String searchWord) {
        List<String> list =map.getOrDefault(searchWord.length(),new ArrayList<String>());
        if(list.isEmpty()){
            return false;
        }
        for (String s: list
             ) {
            int count = 0;
            for(int i = 0;i < s.length(); i++){
                if(s.charAt(i) != searchWord.charAt(i)){
                    count++;
                }
            }
            if(count == 1){
                return true;
            }
        }
        return false;
    }
}
