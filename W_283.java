package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class W_283 {
    public List<String> cellsInRange(String s) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c = s.charAt(0); c <= s.charAt(3); c++) {
            sb.delete(0,sb.length());
            sb.append(c);
            for (int i = s.charAt(1); i <= s.charAt(4); i++) {
                sb.append(i - '0');
                list.add(sb.toString());
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return list;
    }

    /**
     * 遍历数组，查看当前位置元素是否为合理的最小数字。
     * 奇怪的题目。
     * @param nums
     * @param k
     * @return
     */
    public long minimalKSum(int[] nums, int k) {
        long res = 0L,pre = 1;
        Arrays.sort(nums);
        int n = nums.length,max;
        for (int i = 0; i < n; i++) {
            if (nums[i] > pre){
                // 2  4,加入2，3，sum = 5.还要可考虑加多了。
                max = Math.min(k,(int) (nums[i] - pre));
                k -= max;
                res += max * (2L * pre + max - 1)/2;
            }
            if (k == 0){
                break;
            }
            pre = nums[i] + 1;
        }
        //没加完
        if (k > 0){
            res += k * (2L * nums[n - 1] + 1 + k) / 2;
        }
        return res;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        int[] degree = new int[(int) (1e5 + 7)];
        Arrays.fill(degree,-1);
        TreeNode[] list = new TreeNode[(int) (1e5 + 7)];
        int parent ,child,left;
        for (int i = 0; i < n; i++) {
            parent = descriptions[i][0];
            child = descriptions[i][1];
            left = descriptions[i][2];
            if (list[parent] == null){
                list[parent] = new TreeNode(parent);
            }
            if (list[child] == null){
                list[child] = new TreeNode(child);
            }
            if (left == 1){
                list[parent].left = list[child];
            }else{
                list[parent].right = list[child];
            }
            if (degree[child] == -1){
                degree[child] = 0;
            }
            if (degree[parent] == -1){
                degree[parent] = 0;
            }
            degree[child]++;
        }
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0){
                return list[i];
            }
        }
        return null;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        /**
         * 删除完当前两个元素+添加LCM之后，还要将LCM与之前的数字比较。
         */
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            while (list.size() >= 2){
                int first = list.get(list.size() - 1);
                int second = list.get(list.size() - 2);
                int temp = gcd(first,second);
                if (temp == 1){
                    break;
                }
                list.remove(list.size() - 1);
                list.set(list.size() - 1,lcm(first,second,temp));
            }
        }
        return list;
    }
    private int lcm(int a,int b,int gcd){
        return a / gcd * b;
    }

    private  int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

        public static void main(String[] args) {
        new W_283().replaceNonCoprimes(new int[]{6,4,3,2,7,6,2});
    }
}
