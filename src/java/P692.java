/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * Result should be lexicographically sorted (for words having same frequency)
 * Complexity:
 *   Space: O(k) for minHeap and resultant list
 *   Time: O(nlogk) + O(k^2) : O(k^2) is due to statement: result.add(0, minHeap.poll().getKey());
 *         All the elements are added to index 0, making the elements move every time an element
 *         is added. This will lead to 0+1+2+3+4+...k-1 movements for adding k elements to result
 */
package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class P692 {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> hm = new HashMap<>();
    for(String word: words){
      hm.put(word, 1+hm.getOrDefault(word,0));
    }

    PriorityQueue<Entry<String,Integer>> minHeap =
        new PriorityQueue<>((e1,e2) -> e1.getValue() - e2.getValue() != 0 ? e1.getValue() - e2.getValue() : e2.getKey().compareTo(e1.getKey()));

    //Add all elements in minHeap, limiting size of heap to be k
    for (Map.Entry<String, Integer> entry : hm.entrySet()) {
      minHeap.add(entry);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }


    ArrayList<String> result = new ArrayList<>(k+1);
    int index = k;
    while(!minHeap.isEmpty()){
      result.add(0, minHeap.poll().getKey());
      index--;


    }

    return result;

  }

}
