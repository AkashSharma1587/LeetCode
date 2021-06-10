/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/
 * Longest consecutive path between any two nodes (can be incrementing / decrementing in nature)
 *
 *
 * Solution: At each node, store two values (incr, dcr) which depict
 * incr : the downward increasing consecutive path size AND
 * dcr:   the downward decreasing consecutive path size
 * value at node: incr + dcr - 1 (because the node would have been counted twice, once each in incr and dcr
 *
 */
package java;

public class P549 {
  int max = 0;
  public int longestConsecutive(TreeNode root) {

    dfs(root);
    return max;

  }

  public int[] dfs(TreeNode node){
    if(node == null)
      return new int[] {0,0};

    int incr = 1, dcr = 1;
    if(node.left != null){
      int [] leftVal = dfs(node.left);
      if(node.val == node.left.val + 1)
        dcr = leftVal[1] + 1;
      else if(node.val == node.left.val - 1)
        incr = leftVal[0] + 1;
    }

    if(node.right != null){
      int [] rightVal = dfs(node.right);
      if(node.val == node.right.val + 1)
        dcr = Math.max(dcr, rightVal[1] + 1);
      else if (node.val == node.right.val - 1)
        incr = Math.max(incr, rightVal[0] + 1);
    }

    max = Math.max(max, incr+dcr-1);
    return new int[] {incr, dcr};
  }

}
