/**
 * https://leetcode.com/problems/subarray-product-less-than-k/
 * Sliding Window solution
 */


package java;

public class P713 {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if(k <= 1)
      return 0;

    int prod = 1;

    int count = 0;

    int left = 0;

    for(int right = 0; right < nums.length; right++){
      prod*=nums[right];
      while(prod >= k){
        prod /= nums[left];
        left++;
      }
      count += (right - left + 1);

    }
    return count;
  }

}