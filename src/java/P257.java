/**
 * https://leetcode.com/problems/binary-tree-paths/
 * Build paths from root to leaf (for all such paths) in the form of ["a->b->c","a-x"] where a is root,
 * and c and x are leaves
 *
 * Note: Use StringBuilder to avoid String concat.
 *       However, beware that recursion stack with StringBuilder modifies the original value
 *       Always make a copy of StringBuilder insde the recursion method
 */

package java;

import java.util.ArrayList;
import java.util.List;

public class P257 {
  List<String> result = new ArrayList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    if(root == null)
      return new ArrayList<>();
    StringBuilder path = new StringBuilder("");
    dfs(root, path);
    return result;
  }


  public void dfs(TreeNode node, StringBuilder localPath){
    if(node == null){
      return;
    }

    StringBuilder path = new StringBuilder(localPath.toString());

    path.append(node.val);

    if(node.left!=null || node.right!=null){
      path.append("->");
      dfs(node.left, path);
      dfs(node.right, path);
    }
    else{
      result.add(path.toString());
    }
  }
}
