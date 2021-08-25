package com.fengtin.LeetCode;

public class D_108 {
    /**
     * 有序数组转化为平衡二叉树。二分法一直分？
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = dfs(nums,0,nums.length - 1);
        return root;
    }
    private TreeNode dfs(int[] nums,int begin,int end){
        if(begin > end){
            return null;
        }
        if(begin == end){
            return new TreeNode(nums[end]);
        }
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,begin,mid - 1);
        root.right = dfs(nums,mid+1,end);
        return root;
    }

    public static void main(String[] args){
        System.out.println(new D_108().sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
