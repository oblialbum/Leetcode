package com.fengtin.LeetCode;

import java.util.*;

public class W_270 {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length,p = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(digits[i] == 0){
                continue;
            }
            for (int j = 0; j < n; j++) {
                if(j == i){
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if(k == i || k == j){
                        continue;
                    }
                    if(digits[k] % 2 == 0){
                        set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                    }
                }
            }
        }
        int[] res = new int[set.size()];
        for (int key: set
             ) {
            res[p++] = key;
        }
        Arrays.sort(res);
        return res;
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }
        ListNode slow = head,fast = head.next,pre = null;
        /**
         * 为奇数时，slow刚好指向 第 n/2 向下取整 个节点。
         * 为偶数时，slow刚好指向目标节点前一个。
         */
        while (fast != null){
            if(fast.next == null){
                break;
            }
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null){
            pre.next = slow.next;
        }
        else{
            slow.next = slow.next.next;
        }
        return head;
    }
    Map<Integer,Integer> parents;
    Map<Integer,HashMap<Integer,Character>> child;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        parents = new HashMap<>();
        child = new HashMap<>();
        dfs(0,root,'0');
        Set<Integer> set = new HashSet<>();
        int commonAncestor = -1,p = startValue,q =destValue;
        /**
         * 寻找最近公共祖先。
         */
        while (set.add(p) && parents.containsKey(p)){
            p = parents.get(p);
        }
        while (true){
            if(set.add(q) && parents.containsKey(q)){
                q = parents.get(q);
            }
            else{
                commonAncestor = q;
                break;
            }
        }
        System.out.println(commonAncestor);
        StringBuilder sb = new StringBuilder();
        while (destValue != commonAncestor){
            int next = parents.get(destValue);
            sb.append(child.get(next).get(destValue));
            destValue = next;
        }
        sb.reverse();
        while (startValue != commonAncestor){
            startValue = parents.get(startValue);
            sb.insert(0,'U');
        }
        return sb.toString();
    }

    private void dfs(Integer parent,TreeNode root,char dir) {
        if(root == null){
            return;
        }
        if(parent != 0){
            parents.put(root.val,parent);
        }
        if(dir != '0'){
            HashMap<Integer,Character> map = child.getOrDefault(parent,new HashMap<>());
            map.put(root.val,dir);
            child.put(parent,map);
        }
        dfs(root.val,root.left,'L');
        dfs(root.val,root.right,'R');
    }
}
