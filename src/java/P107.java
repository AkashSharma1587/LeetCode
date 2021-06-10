// Level order traversal but bottoms up print
package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P107 {

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


  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

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


      result.add(levelList);
    }

    Collections.reverse(result);
    return result;



  }

}
