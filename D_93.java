package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_93 {
    private static List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<String>();
        /**
         * 下述三个指针将字符串划分为4部分，每部分对应IP地址的一个部分。具体数值分别代表该部分截止到哪里。
         * i:第一层指针
         * j:第二层指针
         * k:第三层指针
         */
        if(s.length() < 4){
            return answer;
        }
        for(int i = 0;i < 3; i++){
            if(s.substring(0,i+1).length() >= 2 && s.substring(0,i+1).startsWith("0")){
                continue;
            }
            if(Integer.valueOf(s.substring(0,i+1)) > 255){
                continue;
            }
            int j = i +1,k = s.length() - 1 - 1;
            for(;k > j;k--){
                if(s.length() - 1 - k >3){
                    break;
                }
                if(s.substring(k+1).length() >= 2 && s.substring(k+1).startsWith("0")){
                    continue;
                }
                if(Integer.valueOf(s.substring(k+1)) > 255){
                    continue;
                }
                for(;k > j;j++){
                    if(k - j >3){
                        continue;
                    }
                    if(j - i > 3){
                        break;
                    }
                    if(s.substring(i+1,j+1).length() >= 2 && s.substring(i+1,j+1).startsWith("0")){
                        continue;
                    }
                    if(Integer.valueOf(s.substring(i+1,j+1)) > 255){
                        continue;
                    }
                    if(s.substring(j+1,k+1).length() >= 2 && s.substring(j+1,k+1).startsWith("0")){
                        continue;
                    }
                    if(Integer.valueOf(s.substring(j+1,k+1)) > 255){
                        continue;
                    }
                    answer.add(s.substring(0,i+1)+"."+s.substring(i+1,j+1)+"."+s.substring(j+1,k+1)+"."+s.substring(k+1));
                }
                j = i + 1;
            }
        }
        return answer;
    }

    private static List<String> restoreIpAddresses1(String s) {
        List<String> answer = new ArrayList<String>();
        dfs(new ArrayList<String>(),answer,s,1,0);
        return answer;

    }

    /**
     *
     * @param list
     * @param answer
     * @param s
     * @param times    选取第times字串
     * @param beginIndex 该次选取字串包含beginIndex,不包含endIndex.
     */
    private static void dfs(List<String> list,List answer,String s,int times,int beginIndex){
        if(times == 5){
            String ans = list.get(0)+"." + list.get(1) + "." + list.get(2) + "." + list.get(3);
            answer.add(ans);
            return;
        }
        if(times == 4){
            if(s.length() - beginIndex > 3){
                return;
            }
            String temp = s.substring(beginIndex);
            if(Integer.valueOf(temp) > 255){
                return ;
            }
            if(temp.startsWith("0") && s.length() - beginIndex >= 2){
                return;
            }
            list.add(temp);
            dfs(list,answer,s,times+1,s.length());
            list.remove(times - 1);
        }
        else {
            for (int endIndex = beginIndex + 1; endIndex <= beginIndex + 3 && s.length() - 3 + times > endIndex; endIndex++) {
                String temp = s.substring(beginIndex, endIndex);
                if(Integer.valueOf(temp) > 255){
                    return ;
                }
                if(temp.startsWith("0") && temp.length() == 2){
                    return;
                }
                list.add(temp);
                dfs(list, answer, s, times + 1, endIndex);
                list.remove(times - 1);
            }
        }
    }
    public static void main(String[] args){
        System.out.println(restoreIpAddresses1("25525511135"));
    }
}
