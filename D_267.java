package com.fengtin.LeetCode;

import java.util.TreeSet;

public class D_267 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        while (tickets[k] >0 ){
            for (int i = 0; i < tickets.length; i++) {
                if(tickets[i] > 0){
                    tickets[i]--;
                    ans++;
                }
                if(tickets[k] == 0){
                    break;
                }
            }
        }
        return ans;
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        int  end = 1,cur = 1,add = 2,n = 0;
        ListNode p = head;
        TreeSet<Integer> set = new TreeSet<>();
        while (p != null){
            p = p.next;
            n++;
        }
        if(n == 1){
            return head;
        }
        for (int i = 0; (i + 1) * i / 2 <= n; i++) {
            set.add((i + 1) * i / 2);
        }
        int last = set.floor(n);
        p = head;
        while (p != null){
            if(cur == end){
                /**
                 * 最后一组待处理节点.
                 */
                if(end == last){
                    p.next = reverse(p.next,add);
                    break;
                }
                if(add % 2 == 0) {
                    p.next = reverse(p.next, add);
                }
                end += add;
                add++;
            }
            p = p.next;
            cur++;
        }
        return head;
    }

    private ListNode reverse(ListNode root, int add) {
        if(root == null){
            return null;
        }
        int cur = 1;
        ListNode end = root,next,pre = null,p = root;
        while (cur  < add){
            if(end.next == null){
                if(cur % 2 == 0){
                    break;
                }
                else{
                    return root;
                }
            }
            end = end.next;
            cur++;
        }
        next = end .next;
        while (p != end){
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        end.next = pre;
        root.next = next;
        return end;
    }

    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length() / rows;
        int p = 0;
        char[][] array = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = encodedText.charAt(p++);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cols; i++) {
            for (int row = 0; row < rows; row++) {
                if(i + row == cols){
                    break;
                }
                sb.append(array[row][i + row]);
            }
        }
        String ans = sb.toString();
        int indexOfSpace = ans.length();
        for (int i = indexOfSpace - 1; i >= 0; i--) {
            if(ans.charAt(i) == ' '){
                indexOfSpace--;
            }
            else {
                break;
            }
        }
        return ans.substring(0,indexOfSpace);
    }
}
