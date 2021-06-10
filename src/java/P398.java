//Random Index Pick
package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class P398 {

  Map<Integer, List<Integer>> hm = new HashMap<>();
  public P398(int[] nums) {
     for(int i = 0; i < nums.length; i++){
        if(hm.containsKey(nums[i])){
          List<Integer> indexList = hm.get(nums[i]);
          indexList.add(i);
          hm.put(nums[i], indexList);
        } else{
          hm.put(nums[i], new ArrayList<>(i));
        }
     }
  }

  public int pick(int target) {
      List<Integer> indexList = hm.get(target);
      Random random = new Random();
      return indexList.get(random.nextInt(indexList.size()));
  }

}
