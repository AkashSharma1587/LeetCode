/**
 * https://leetcode.com/problems/top-k-frequent-elements/submissions/
 * TOP K Frequent Elements
 * DS: MinHeap based on frequency of elements. Note that the array is static and not a running
 *     stream
 * Time: NlogK
 * Space: K
 */

package java;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class P347 {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> hm = new HashMap<>();
    for(int num: nums){
      hm.put(num, 1+hm.getOrDefault(num,0));
    }

    PriorityQueue<Map.Entry<Integer,Integer>> minHeap =
        new PriorityQueue<>((e1,e2) -> e1.getValue() - e2.getValue());

    //Add all elements in minHeap, limiting size of heap to be k
    for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
      minHeap.add(entry);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }


    int[] result = new int[k];
    int index = 0;
    while(!minHeap.isEmpty()){
      result[index++] = minHeap.poll().getKey();
    }

    return result;

  }

}
