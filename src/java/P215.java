//Kth largest number in an array.
package java;

import java.util.PriorityQueue;

public class P215 {
  class Solution {
    public int findKthLargest(int[] nums, int k) {
      if(k > nums.length)
        return -1;

      PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, (a,b)-> Integer.compare(a,b));

      int count = k;

      for(int i = 0; i<nums.length; i++){
        if(count > 0){
          minHeap.offer(nums[i]);
          count--;
        }else{
          if(nums[i] > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(nums[i]);
          }
        }
      }

      return minHeap.peek();



    }
  }

}
