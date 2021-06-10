// https://leetcode.com/problems/longest-consecutive-sequence/
/**
 * Longest Consecutive Sequence:
    Input: [100,4,200,1,3,2]
    Output: 4 (because 1,2,3,4 forms longest consecutive sequence)
 */
package java;

import java.util.HashSet;
import java.util.Set;

public class P128 {
  public int longestConsecutive(int[] nums) {
    Set<Integer> hashSet = new HashSet<>();

    //Put all numbers in HashSet for O(1) lookup
    for(int num : nums){
      hashSet.add(num);
    }


    int max = 0;

    for(int num: nums){
      //We choose to build the sequence only in forward direction.
      //So, if the numbers are 4,5,0,-1,3
      //We will start with 4, but will not build the sequence since 3 is present
      //Similarly, we won't start with 5 as well since 4 is present
      //Similarly, we won't start with 0 as well since -1 is present
      //We will start with -1 since there is no preceding element
      //Starting with -1, we will get -1,0
      //Starting with 3, we will get 3,4,5
      //Output: 3
      if(!hashSet.contains(num-1)){

        int currentNum = num;
        int count = 1;

        while(hashSet.contains(currentNum+1)){
          currentNum+=1;
          count++;
        }

        max = Math.max(max, count);
      }

    }
    return max;
  }

}
