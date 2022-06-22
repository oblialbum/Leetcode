package com.fengtin.LeetCode;

public class NumArray {
    private int[] segmentTree;
    private int n;
    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[n * 4];
        build(0,0,n - 1,nums);
    }


    public void update(int index,int val){
        change(index,val,0,0,n - 1);
    }


    public int sumRange(int left, int right) {
        return range(left,right,0,0,n - 1);
    }

    private void build(int node, int s, int e, int[] nums) {
        if (s == e){
            segmentTree[node] = nums[s];
            return;
        }
        int m = (e + s)>>1;
        build(node * 2+1,s,m,nums);
        build(node * 2 + 2,m +1,e,nums);
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    private void change(int index, int val, int node, int s, int e) {
        if (s == e){
            segmentTree[node] = val;
            return;
        }
        int mid = s + (e - s)>>1;
        if (index <= mid){
            change(index,val,node * 2 + 1,s,mid);
        }else{
            change(index,val,node * 2 + 2,mid + 1,e);
        }
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    private int range(int left, int right, int node, int s, int e) {
        if (left == s && right == e){
            return segmentTree[node];
        }
        int mid = s + (e - s) >> 1;
        if (right <= mid){
            return range(left,right,node * 2 + 1,s,mid);
        }else if (left > mid){
            return range(left,right,node * 2 + 2,mid + 1,e);
        }else{
            return range(left,mid,node *2 + 1,s,mid) + range(mid + 1,right,node * 2 + 2,mid+1,e);
        }
    }

    public static void main(String[] args) {
        new NumArray(new int[]{0,9,5,7,3});
    }
}
