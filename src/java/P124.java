//Binary Tree Maximum Path Sum
//
package java;

public class P124 {
  int maxVal = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {

    maxGain(root);
    return maxVal;

  }

  public int maxGain(TreeNode node){
    if(node == null)
      return 0;

    int leftGain = Math.max(maxGain(node.left), 0);
    int rightGain = Math.max(maxGain(node.right), 0);

    int maxValAtNode = node.val + leftGain + rightGain;
    maxVal = Math.max(maxVal, maxValAtNode);
    int returnValue = node.val + Math.max(leftGain, rightGain);
    return returnValue;
  }
}
