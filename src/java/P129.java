//Sum Root to Leaf
// Each root to leaf path can be mentioned as a number. Find sum of all the root-leaf paths represented as numbers
// https://leetcode.com/problems/sum-root-to-leaf-numbers/
package java;

public class P129 {
  int ans = 0;
  public int sumNumbers(TreeNode root) {
    if(root == null)
      return 0;

    dfs(root, 0);
    return ans;

  }

  public int dfs(TreeNode node, int sum){
    if(node == null)
      return 0;

    sum = sum * 10 + node.val;
    if(node.left == null && node.right==null)
      ans += sum; String s ;



    dfs(node.left, sum);
    dfs(node.right, sum);

    sum = (sum - node.val)/10;

    return sum;
  }
}
