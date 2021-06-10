/**
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 * Each node represents an alphabet (values of the node can range 0-25 representing a-z
 * Need to find lexicographically shortest string starting from leaf to root.
 */
package java;

public class P988 {
  String ans;
  public String smallestFromLeaf(TreeNode root) {
    dfs(root, new StringBuilder());
    return ans;
  }

  public void dfs(TreeNode node, StringBuilder sb){
    if(node == null)
      return;

    sb.append((char)('a' + node.val));

    //Leaf Node
    if(node.left == null && node.right == null){
      sb.reverse();
      String s = sb.toString();
      sb.reverse();

      //Compare the computed string with the running answer
      if(ans == null)
        ans = s;
      else {
        if(s.compareTo(ans) < 0){
          ans = s;
        }
      }


    }

    dfs(node.left, sb);
    dfs(node.right, sb);
    sb.deleteCharAt(sb.length() - 1);//Remove the last character while moving up
  }
}
