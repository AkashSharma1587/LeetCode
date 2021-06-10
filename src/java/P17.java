// Letter Combination
package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17 {

  public List<String> letterCombinations(String digits) {
    List<StringBuilder> result = new ArrayList<>();
    Map<Character, String> hm = new HashMap<>();
    hm.put('2', "abc");
    hm.put('3', "def");
    hm.put('4', "ghi");
    hm.put('5', "jkl");
    hm.put('6', "mno");
    hm.put('7', "pqrs");
    hm.put('8', "tuv");
    hm.put('9', "wxyz");


    for(int i = 0; i < digits.length(); i++){
      Character key = digits.charAt(i);
      System.out.println("Digit : "+key) ;
      result = combine(hm, key, result);
    }

    List<String> resultsInStr = new ArrayList<>();
    for(StringBuilder sb : result){
      resultsInStr.add(sb.toString());
    }
    return resultsInStr;
  }




  public List<StringBuilder> combine(Map<Character, String> mapper, Character key, List<StringBuilder> tempList)     {
    List<StringBuilder> sbList = new ArrayList<>();
    String val = mapper.get(key);

    if(tempList.size() == 0){
      for(Character ch : val.toCharArray()){
        StringBuilder sb = new StringBuilder(String.valueOf(ch));
        sbList.add(sb);
      }
    }
    else{
      for(int i = 0; i < tempList.size(); i++){
        StringBuilder sb = tempList.get(i);
        for(int j = 0; j < val.length(); j++){
          StringBuilder sbTemp = new StringBuilder(sb.toString());
          sbList.add(sbTemp.append(val.charAt(j)));
        }
      }
    }//end of if-else


    return sbList;


  }

}
