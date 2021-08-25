package com.fengtin.LeetCode;

public class D_109 {
    /**
     * 将有序链表转化为平衡二叉树。
     * 暴力方法：将链表转化为数组，再用二分+递归。
     * 每层递归用快慢指针找中间节点。
     * 时间复杂度更低的方法：中序遍历+递归，看不下去了。
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = dfs(head,null);
        return root;
    }
    private TreeNode dfs(ListNode head,ListNode end){
        if(head == end){
            return null;
        }
        if(head.next == end){
            return new TreeNode(head.val);
        }
        ListNode p = head;
        ListNode pre = head;
        /**
         * 节点个数为奇数：正好p指向最后一个节点，pre指向中间一个。
         * 节点个数为偶数：p指向倒数第二个，pre指向中间俩个的左边一个。
         */
        while (p.next != end && p.next.next != end ){
            p = p.next.next;
            pre = pre.next;
        }
        p = pre.next;
        TreeNode root = new TreeNode(pre.val);
        root.left = dfs(head,pre);
        root.right = dfs(p,end);
        return root;
    }

    public static void main(String[] args){
        int[] a = new int[]{0,1,2,3,4,5,6};
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i = 1;i < a.length;i++){
            p.next = new ListNode(a[i]);
            p = p.next;
        }
        new D_109().sortedListToBST(head);
    }
}
