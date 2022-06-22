package com.fengtin.LeetCode;

public class D_167 {
    /**
     * 俩数之和，答案唯一,不能使用同一个元素，即结果不能是俩个相同的下标。
     * @param numbers 有序非递减数组。
     * @param target
     * @return 返回下标。
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for(int i = 0,j = numbers.length - 1;i < j;){
            if(i > 0 && numbers[i] == numbers[i - 1]){
                i++;
                continue;
            }
            if(j < numbers.length - 1 && numbers[j] == numbers[j + 1]){
                j--;
                continue;
            }
            if(numbers[i] + numbers[j] == target){
                ans[0] = i + 1;
                ans[1] = j + 1;
                return ans;
            }
            if(numbers[i] + numbers[j] < target){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        new D_167().twoSum(new int[]{0,0,3,4},0);
    }
}
