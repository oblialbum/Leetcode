package com.fengtin.LeetCode;

public class D_81 {
    /**
     * step1:find index of minData.
     * @param nums 非降序数组旋转之后的结果，可能存在相同元素。
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }
        int left = 0,right = nums.length - 1,minIndex = -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if( nums[mid] > nums[right]){
                left = mid + 1;
            }
            if(nums[mid] < nums[right]){
                right = mid;
            }
            if(nums[mid] == nums[right]){
                /**
                 * 向左搜索，判断做部分元素是否完全相同。
                 */
                while(mid >= left && nums[mid] == nums[right]){
                    mid--;
                }
                if(mid >= left){
                    if(nums[mid] < nums[right]){
                        right = mid;
                    }
                    else{
                        left = mid + 1;
                    }
                }
                /**
                 * 左边元素完全相同，判断右边元素。
                 */
                else{
                    mid = left + (right - left) / 2;
                    while(mid <= right && nums[mid] == nums[right]){
                        mid++;
                    }
                    if(mid <= right){
                        if(nums[mid] < nums[right]){
                            right = mid;
                        }
                        else{
                            left = mid + 1;
                        }
                    }
                    /**
                     * 当前区间内元素全部相同，退出循环。
                     */
                    else{
                        break;
                    }
                }
            }
        }
        minIndex = left;
        if(target  < nums[minIndex] || (minIndex > 0 && nums[minIndex - 1] < target)){
            return false;
        }
        if(binarySearch(nums,minIndex,nums.length - 1,target)){
            return true;
        }
        if(binarySearch(nums,0,minIndex - 1,target)){
            return true;
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int left, int right,int target) {
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        new D_81().search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1},2);
    }
}
