/**
 * https://leetcode.com/problems/even-odd-tree/
 *
 * Solution: BFS
 */

package java;

import java.util.LinkedList;

import java.util.Queue;

public class P1609 {
  public boolean isEvenOddTree(TreeNode root) {
    if(root == null)
      return false;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int level = -1;
    while(!queue.isEmpty()){
      level++;
      int size = queue.size();
      TreeNode prev = null;
      boolean isLevelEven = (level%2 == 0);
      for(int i = 0; i < size; i++){
        TreeNode node = queue.poll();
        boolean isNodeEven = (node.val%2 == 0);
        if(isLevelEven){
          if(isNodeEven)
            return false;

          if(prev!=null && prev.val >= node.val)
            return false;
          prev = node;
        }

        if(!isLevelEven){
          if(!isNodeEven)
            return false;

          if(prev != null && prev.val <= node.val)
            return false;
          prev = node;

        }

        if(node.left!=null)
          queue.offer(node.left);
        if(node.right!=null)
          queue.offer(node.right);
      }//end of for-loop


    }//end of while loop

    return true;
  }//end of method

}
