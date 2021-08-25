package com.fengtin.LeetCode;

import java.util.*;

public class D_103 {
    /**
     * 层序遍历变形，奇数层不变，偶数层反方向遍历（用栈，最后一个遍历的结果在下一层第一个被处理）。
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int floor = 2;
        while(!queue.isEmpty()){
            int curSize = queue.size();
            for(int i = 0;i < curSize; i++){
                root = queue.poll();
                list.add(root.val);
                if(root.left != null){
                    queue.add(root.left);
                }
                if(root.right != null){
                    queue.add(root.right);
                }
            }
            if(floor % 2 == 0){
                Collections.reverse(list);
            }
            floor++;
            ans.add(new ArrayList(list));
            list.clear();
        }
        return ans;
    }
}
