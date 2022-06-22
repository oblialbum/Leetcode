package com.fengtin.LeetCode;

public class D_60 {
    /**
     * 返回全排列中的第k个排列，从小到达顺序。
     */
    StringBuffer ans = new StringBuffer();
    boolean[] visited;
    int times ;
    public String getPermutation(int n, int k) {
        times = k;
        int[] nums = new int[n];
        visited = new boolean[n];
        for(int i = 0;i < n;i++){
            nums[i] = i + 1;
        }
        traceBack(0,nums);
        return ans.toString();
    }

    private boolean traceBack( int pos, int[] nums) {
        if(pos == nums.length){
            times--;
            return times == 0;
        }
        /**
         * 保证从小到大的顺序插入数字。
         */
        for(int i = 0 ;i < nums.length;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            ans.append(nums[i]);
            if(traceBack(pos + 1,nums)){
                return true;
            }
            ans.deleteCharAt(pos);
            visited[i] = false;
        }
        return false;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public String getPermutation1(int n, int k){
        if(n == 1){
            return "1";
        }
        String ans = "";
        int[] fabo = new int[10];
        fabo[0] = fabo[1] = 1;
        for(int i = 2;i < fabo.length;i++){
            fabo[i] = i * fabo[i - 1];
        }


        int num ;
        boolean[] visited = new boolean[n + 1];
        /**
         * Num记录当前位置应该填入的数字。
         * for循环从头开始寻找第num小的数字进行填入。
         * k重复赋值。
         */
        for(int pos = n - 1; pos > 0 && k > 0;pos--){
            num = (k - 1) / fabo[pos] + 1;
            for(int i = 1;i < visited.length;i++){
                if(visited[i]){
                    continue;
                }
                num --;
                if(num == 0){
                    ans += i;
                    visited[i] = true;
                    break;
                }
            }
            k %= fabo[pos];
        }
        /**
         * k == 0时，如果还有位置没填充，遍历visited数组，big-->small。
         */
        for(int i = visited.length - 1;i > 0;i--){
            if(!visited[i]){
                ans += i;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        new D_60().getPermutation1(3,2);
    }
}

