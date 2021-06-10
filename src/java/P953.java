//Is Alien Dictionary Words sorted
package java;

import java.util.HashMap;
import java.util.Map;

public class P953 {
  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < order.length(); i++){
      map.put(order.charAt(i), i);
    }



    for(int i = 0; i < words.length-1; i++){
      String first = words[i];
      for(int l = i+1; l < words.length; l++ ){
        String second = words[l];

        System.out.println("First word = "+first);
        System.out.println("Second word = "+second);
        if(first.startsWith(second) && first.length() > second.length())
          return false;

        for(int j = 0, k= 0; j < first.length() && k < second.length(); j++, k++){
          if(first.charAt(j) == second.charAt(k)){
            continue;
          }
          else{
            if(map.get(first.charAt(j)) > map.get(second.charAt(k))){
              return false;
            }else {
              break;
            }
          }
        }//end of word comparison for loop

      }//end of l for loop


    }//end of words iteration for loop

    return true;

  }//End of isAlienSorted

}

//Only Adjacent number can be compared, making it
