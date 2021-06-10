/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
package java;

public class P560 {
  public int subarraySum(int[] nums, int k) {

    int sums[] = new int[nums.length+1];
    sums[0] = 0;
    for(int i = 1; i <= nums.length; i++){
      sums[i] = sums[i-1] + nums[i-1];
    }

    int count = 0;
    for(int i = 0; i < nums.length; i++){
      for(int j = i+1; j <= nums.length; j++){
        int diff = sums[j] - sums[i];
        if(diff == k){
          count++;
        }
      }
    }

    return count;

  }

}
