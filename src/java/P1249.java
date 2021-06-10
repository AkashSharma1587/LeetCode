//Remove min number of brackets to make string valid
// a(k(a))s) => a(k(a))s : Removes 1 )
// )a(a(k)a(s))( => aa(a(k)a(s)) : Removes 1 ), Removes 1 (
package java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class P1249 {
  public String removeMinCharactersToMakeValid(String s){
    String result = null;
    Set<Integer> indexesToRemove = new HashSet<>();
    //Stack stack = new Stack();
    //Don't use Stack class. Use Deque interface as it is better.
    Deque<Integer> dq = new ArrayDeque<>();


    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) == '('){
         dq.push(i);
      }

      if(s.charAt(i) == ')'){
        if(dq.isEmpty())
          indexesToRemove.add(i);
        else
          dq.pop();
      }
    }//end of for-loop

    while(!dq.isEmpty())
      indexesToRemove.add(dq.pop());//These are the extra '(' without matching ')'

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.length(); i++){
      if(!indexesToRemove.contains(i)){
        sb.append(s.charAt(i));
      }
    }

    return sb.toString();
  }

}
