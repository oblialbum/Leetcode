package com.fengtin.LeetCode;

import java.util.Stack;

public class D_71 {
    public String simplifyPath(String path) {
        Stack<Character> stack = new Stack();
        for(int i = 0;i < path.length();i++){
            if(path.charAt(i) == '/'){
                if(!stack.isEmpty() && i == path.length() - 1){
                    if(stack.peek() == '/' && stack.size() != 1){
                        stack.pop();
                    }
                    continue;
                }
                if(!stack.isEmpty() && stack.peek() =='/'){
                    continue;
                }
                stack.push(path.charAt(i));
            }
            else if(path.charAt(i) == '.'){
                /**
                 * 作为文件名的一部分，无需特殊处理。
                 */
                if(!stack.isEmpty() && stack.peek() != '/'){
                    stack.push(path.charAt(i));
                    continue;
                }
                /**
                 * 记录一共有多少个连续的点。
                 */
                int count = 0;
                while(i < path.length() && path.charAt(i) == '.'){
                    count++;
                    i++;
                }
                if(i < path.length() && path.charAt(i) != '/'){
                    while(count > 0){
                        stack.push('.');
                    }
                    i--;
                    continue;
                }
                /**
                 * 恢复位置，指向当前最后一个点。
                 */
                i--;
                /**
                 * 处理 .. 和 .
                 */
                if(count > 2){
                    while(count > 0){
                        stack.push('.');
                        count--;
                    }
                }
                int frontDirNum = count / 2;
                int curNum = count % 2;
                while (frontDirNum > 0){
                    if(stack.size() == 1){
                        break;
                    }
                    /**
                     * 回到上一级目录：需要删除俩个 '/'。
                     */
                    for(int j = 0;j < 2;j++) {
                        while (!stack.isEmpty() && stack.pop() != '/') {

                        }
                        if(stack.isEmpty()){
                            stack.push('/');
                            break;
                        }
                    }
                    frontDirNum--;
                }
                while(curNum > 0){
                    while (!stack.isEmpty() && stack.pop() != '/') {
                    }
                    if(stack.isEmpty()){
                        stack.push('/');
                        break;
                    }
                    curNum--;
                }
                continue;
            }
            else{
                stack.push(path.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Character c: stack
             ) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        new D_71().simplifyPath("/a//b////c/d//././/..");
    }
}
