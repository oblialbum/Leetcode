package com.fengtin.LeetCode;

public class D_19 {
    /**
     * 暴力解法：多次遍历，easy.
     * 一次遍历：dfs?
     * @param head
     * @param n
     * @return
     */
    int count = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode root = new ListNode(-1) ;
        root.next = head;
        dfs(root, n);
        return root.next;
    }

    private void dfs(ListNode head,int n) {
        if(head == null){
            count++;
            return;
        }
        dfs(head.next,n);
        /**
         * count：当前递归处理的倒数第count个节点（null除外），需要删除。
         * 还是像俩次遍历。
         */
        if(count == n + 1){
            head.next = head .next.next;
        }
        count++;
    }
}
