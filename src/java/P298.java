/**
 *  https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 *  Longest consecutive sequence in a binary tree in the direction from top to bottom.
 */

package java;

public class P298 {
  int max = 0;
  public int longestConsecutive(TreeNode root) {
    if(root == null)
      return 0;
    TreeNode prev = null;
    dfs(root, prev, 0);
    return max;
  }


  public void dfs(TreeNode node, TreeNode prev, int count){
    if(node == null){
      return;
    }

    if(prev != null){
      if(node.val == prev.val + 1){
        count += 1;
      } else{
        count = 1;
      }
    } else{
      count = 1;
    }

    max = Math.max(max, count);
    dfs(node.left, node, count);
    dfs(node.right, node, count);
  }

}
