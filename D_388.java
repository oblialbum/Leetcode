package com.fengtin.LeetCode;

import java.util.Stack;

public class D_388 {
    /**
     * 遇到文件再进行长度判断。
     * @param input
     * @return
     */
    public int lengthLongestPath(String input) {
        int res = 0;
        String[] split = input.split("\n");
        System.out.println(split.length);
        Stack<Integer> stack = new Stack<>();
        int cur = -1;
        for (int i = 0; i < split.length; i++) {
            int tabNum = split[i].lastIndexOf("\t") + 1;
            if (tabNum == cur){
                stack.pop();
            }else if (tabNum == cur + 1){
                cur += 1;
            }else{
                while (cur > tabNum){
                    stack.pop();
                    cur--;
                }
                stack.pop();
            }
            int pre = stack.size() == 0 ? 0: stack.peek();
            stack.push(pre + split[i].length() - tabNum);
            if (split[i].contains(".")){
                int len = stack.pop();
                cur--;
                len += stack.size();
                res = Math.max(res,len);
            }
        }
        return res;
    }

    public static void main(String[] args) {
      new D_388().lengthLongestPath("dir\\n        file.txt");
      System.out.println("dir\\n        file.txt".length());
    }
}
