//Average of each level in a Binary Tree
//Optimisation: We only need to sum at each level. So no need to have a List of values at a particular level
package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P637 {
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }



  public List<Double> averageOfLevels(TreeNode root) {

    List<Double> result = new ArrayList<>();

    if(root == null){
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){
      int size = queue.size();
      List<Integer> levelList = new ArrayList<>();
      for(int i = 0; i < size; i++){
        TreeNode node = queue.poll();
        levelList.add(node.val);
        if(node.left != null)
          queue.add(node.left);

        if(node.right != null)
          queue.add(node.right);

      }//end of for-loop

      Double total = 0.0;
      for(Integer i : levelList){
        total += (i*1.0)/(levelList.size());
      }
      result.add(total);
    }

    return result;

  }

}
