//Common of two intervals
package java;

import java.util.ArrayList;
import java.util.List;

public class P986 {

  class Interval{
    int start;
    int end;

    Interval(int start, int end){
      this.start = start;
      this.end = end;
    }
  }

  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

    List<Interval> resultList = new ArrayList<>();

    List<Interval> first = new ArrayList<>();
    List<Interval> second = new ArrayList<>();

    //Convert
    for(int i = 0; i < firstList.length; i++){
      first.add(new Interval(firstList[i][0], firstList[i][1]));
    }

    for(int i = 0; i < secondList.length; i++){
      second.add(new Interval(secondList[i][0], secondList[i][1]));
    }


    int i = 0; int j = 0;

    while(i < first.size() && j < second.size()){
      //Find overlap

      if(
          (first.get(i).start >= second.get(j).start &&
              first.get(i).start <= second.get(j).end)
              ||
              (second.get(j).start >= first.get(i).start &&
                  second.get(j).start <= first.get(i).end
              )
      ){
        Interval interval = new Interval(
            Math.max(first.get(i).start, second.get(j).start),
            Math.min(first.get(i).end, second.get(j).end)
        );

        resultList.add(interval);
      }

      //Move the correct pointer
      if(first.get(i).end < second.get(j).end)
        i++;
      else
        j++;
    }//end of while loop

    //Convert resultList to result
    int result [][] = new int[resultList.size()][2];


    int k = -1;

    if(resultList.isEmpty())
      return result;

    for(Interval it : resultList){
      k++;
      result[k][0] = it.start;
      result[k][1] = it.end;
    }

    return result;


  }

}
