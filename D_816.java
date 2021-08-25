package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_816 {
    /**
     * 二位坐标，只需要将字符串划分为俩部分！！！
     * 划分之后的俩部分，也只需要在每个部分中添加1/0个小数点。
     * @param s
     * @return
     */
    public static List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        /**
         * 遍历所有字符串划分情况。
         * i:第一个字串结束的位置（不包含），第二个字串开始的位置（包含）
         * j:第一个字串中插入小数点的位置，该字符的后面。
         * k:第二个字串插入小数点的位置，该字符的后面。
         */
        String temp = "";
        for(int i = 2;i < s.length() - 1;i++){
            //dfs(i,s,ans,new ArrayList<String>());
            for(int j = 1;j < i;j++){
                if(!isValid(s,1,j,i)){
                    continue;
                }
                /**
                 * 存在剪枝情况：如果某组i,j导致小数点之前的部分以0开头的2/n位数，之后的j循环可以break;
                 */
                for(int k = i;k < s.length() - 1;k++){
                    if(!isValid(s,i,k,s.length() - 1)){
                        continue;
                    }
                    //有些情况下小数点无需添加。
                    temp += s.substring(0,j+1);
                    if(j != i - 1){
                        temp += ".";
                    }
                    temp += s.substring(j+1,i)+", "+s.substring(i,k+1);
                    if(k != s.length()-2){
                        temp +=".";
                    }
                    temp += s.substring(k+1);
                    ans.add(temp);
                    temp = "";
                }
            }
        }
        return ans;
    }

    private static boolean isValid(String s,int begin,int dot,int end){
        if(end - begin == 1) {
            return true;
        }
        if (dot - begin != 0) {
            if (s.charAt(begin) == '0') {
                return false;
            }
        }
        if(end - (dot+1) > 0){
            return !(s.charAt(end - 1) =='0');
        }
        else{
            return true;
        }
    }
    /**
     *XXXXXXXXXXXXXXXX
     * @param pos 子串划分的开始位置
     * @param s
     */
    private static void dfs(int pos,String s,List ans,List list){

    }
    public static void main(String[] args){
        System.out.println(ambiguousCoordinates("(0123)"));
    }
}
