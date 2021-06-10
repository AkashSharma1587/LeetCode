//Find total good nodes. A good node is a node which has the highest value int its path (node to root).
//DFS approach.

package java;

import java.util.ArrayList;
import java.util.List;



class P1448 {
  public int goodNodes(TreeNode root) {
    if(root == null)
      return 0;

    if(root.left == null && root.right == null)
      return 1;

    List<TreeNode> path = new ArrayList<>();
    return dfs(root, path);
  }

  public int dfs(TreeNode node, List<TreeNode> path){
    if(node == null)
      return 0;

    boolean isNodeGood = false;

    int i = 0;
    if(path.size() == 0){
      isNodeGood = true;
    }
    else{
      for(i = path.size() -1 ; i >= 0; i--){
        if(path.get(i).val <= node.val)
          continue;
        else{
          isNodeGood = false;
          break;
        }
      }//end of for loop
    }

    if(i<0)
      isNodeGood = true;

    path.add(node);

    int leftGood = dfs(node.left, path);

    int rightGood = dfs(node.right, path);

    path.remove(path.size() - 1);

    return (isNodeGood == true ? 1 : 0) + leftGood + rightGood;

  }
}