package com.fengtin.LeetCode;

public class D_117 {
  /**
     * 上一题的第一种方法可以解决。
     * 递归：对于任意一个节点，判断:孩子节点是否存在，都存在，作左右相连，判断是否root.next存在。存在则连接到next的第一个孩子节点。
     * 只存在一个，直接进行next第一个孩子节点的连接。
     */
  public Node connect(Node root) {
      if(root == null){
          return null;
      }
      dfs(root);
      return root;
  }

    private void dfs(Node root){
        if(root.left == null && root.right == null){
            return;
        }
        Node temp;
        if(root.left == null){
            temp = root;
            while(temp.next != null){
                if(temp.next.left != null){
                    root.right.next = temp.next.left;
                    break;
                }
                else if(temp.next.right != null){
                    root.right.next = temp.next.right;
                    break;
                }
                temp = temp.next;
            }
            dfs(root.right);
        }
        if(root.right == null){
            temp = root;
            while(temp.next != null){
                if(temp.next.left != null){
                    root.left.next = temp.next.left;
                    break;
                }
                else if(temp.next.right != null){
                    root.left.next = temp.next.right;
                    break;
                }
                temp = temp.next;
            }
            //有待进一步考虑?
            dfs(root.left);
        }
        if(root.right != null && root.left !=null){
            root.left.next = root.right;
            temp = root;
            while(temp.next != null){
                if(temp.next.left != null){
                    root.right.next = temp.next.left;
                    break;
                }
                else if(temp.next.right != null){
                    root.right.next = temp.next.right;
                    break;
                }
                temp = temp.next;
            }
            dfs(root.left);
            dfs(root.right);
        }
    }

}
