package com.fengtin.LeetCode;

public class D_949 {
    String max = "00:00";
    boolean valid = false;
    boolean[] visited;
    public String largestTimeFromDigits(int[] arr) {
       visited = new boolean[arr.length];
       dfs(arr,0,new StringBuilder());
       return valid ? max : "";
    }

    private void dfs(int[] arr, int pos, StringBuilder sb) {
        if (pos == 5){
            if (isValid(sb)){
                valid = true;
            }else{
                return;
            }
            max = max.compareTo(sb.toString()) < 0 ? sb.toString():max;
        }
        if (pos == 2){
            sb.append(":");
            dfs(arr,pos + 1,sb);
            sb.deleteCharAt(2);
        }else{
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]){
                    continue;
                }
                sb.append(arr[i]);
                visited[i] = true;
                dfs(arr,pos+1,sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private boolean isValid(StringBuilder sb) {
        int hour = Integer.parseInt(sb.toString().substring(0,2));
        if (hour > 23 || hour < 0){
            return false;
        }
        hour = Integer.parseInt(sb.toString().substring(3));
        if (hour > 59 || hour < 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new D_949().largestTimeFromDigits(new int[]{1,2,3,4});
    }
}
