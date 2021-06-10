//Path Sum IV
// Given nodes of a tree in format of 3 digit number
// 113 -> Node at depth 1, Position 1 (at depth 1), and value 3.
// Find Sum of all (Root to Leaf paths).

package java;

import java.util.HashMap;
import java.util.Map;

public class P666 {
  Map<Integer, Integer> values;
  int ans = 0;
  public int pathSum(int[] nums) {
    //For each number, find its depth, position and value
    //Find the position of its left and right child
    //Maintain a map of Node to its value

    values = new HashMap<>();

    for(int num: nums){
      int nodeVal = num%10;
      int nodePos = num/10;
      //nodePos contains both level and position within that level.
      //e.g num=123  then nodePos = 12, nodeVal = 3
      values.put(nodePos,nodeVal);
    }

    dfs(nums[0]/10, 0);
    return ans;

  }


  public void dfs(int nodePos, int sum){
    if(!values.containsKey(nodePos)) return;

    sum+=values.get(nodePos);

    int depth = nodePos/10;
    int pos = nodePos%10;

    int leftChildPos = (depth+1)*10 + 2*pos-1;
    int rightChildPos = (depth+1)*10 + 2*pos;

    if(!values.containsKey(leftChildPos) && !values.containsKey(rightChildPos)){
      ans += sum;
    } else{
      dfs(leftChildPos, sum);
      dfs(rightChildPos, sum);
    }
  }//end of dfs

}
