package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        if(nums.length == 0){
            return ans;
        }
        StringBuffer sb = new StringBuffer();
        int begin = nums[0],count = 1;
        sb.append(begin);
        /**
         * 还缺少最后一组数据未处理。
         */
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == nums[i - 1] + 1){
                count++;
            }
            else{
                if(count == 1){
                    ans.add(sb.toString());
                    sb.delete(0,sb.length());
                }
                else{
                    sb.append("->" + (begin + count - 1));
                    ans.add(sb.toString());
                    sb.delete(0,sb.length());
                }
                begin = nums[i];
                count = 1;
                sb.append(begin);
            }
        }
        if(count == 1){
            ans.add(sb.toString());
        }
        else{
            sb.append("->" + (begin + count - 1));
            ans.add(sb.toString());
        }
        return ans;
    }
}
