/**
 * https://leetcode.com/problems/sort-features-by-popularity/
 * Key learning: Arrays.sort
 * Complexity: Let features be O(M) and Responses be O(N)
 *             Space: O(M) in Map (indexMap and freqMap)
 *             Time: O(M*N) + O(MlogM)
 */
package java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1772 {
  public String[] sortFeatures(String[] features, String[] responses) {
    Map<String,Integer> indexMap = new HashMap<>();
    for(int i = 0; i < features.length; i++){
      indexMap.put(features[i],i);
    }

    Map<String,Integer> freqMap = new HashMap<>();
    for(String str : responses){
      String [] split = str.split(" ");
      Arrays.sort(split);
      freqMap.put(split[0], freqMap.getOrDefault(split[0],0)+1);
      for(int i = 1; i < split.length; i++){
        if(split[i].equals(split[i-1])){
          continue;
        }
        freqMap.put(split[i], freqMap.getOrDefault(split[i],0)+1);
      }
    }//End of "responses" iteration


    Arrays.sort(features, (s1, s2) -> {
      if(freqMap.get(s1) == null && freqMap.get(s2)!=null){
        return 1;
      }

      if(freqMap.get(s2) == null && freqMap.get(s1)!=null){
        return -1;
      }

      if (freqMap.get(s1) == freqMap.get(s2)) {
        return (indexMap.get(s1) - indexMap.get(s2));
      }

      return (freqMap.get(s2) - freqMap.get(s1));
    });

    return features;




  }

}
