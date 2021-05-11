//MERGE INTERVALS

package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P56 {
  class Interval{
    int start;
    int end;

    Interval(int start, int end){
      this.start = start;
      this.end = end;
    }
  }

  public int[][] merge(int[][] intervals) {
    //Create Interval Objects
    List<Interval> intervalList = new ArrayList<>();
    for(int i = 0; i<intervals.length; i++){
      Interval interval = new Interval(intervals[i][0], intervals[i][1]);
      intervalList.add(interval);
    }

    if(intervalList.size()<2){
      return intervals;
    }

    //Sort them by start time
    Collections.sort(intervalList, (a,b) -> Integer.compare(a.start, b.start));

    //Iterate and club them
    Interval a = intervalList.get(0);
    int start = a.start;
    int end = a.end;

    List<Interval> result = new ArrayList<>();
    for(int i = 1; i<intervalList.size(); i++){
      Interval b = intervalList.get(i);
      if(b.start <= end){
        end = Math.max(end, b.end); //extending the end of overlapped region
      } else{
        result.add(new Interval(start, end));//this is a merged interval which cannot be clubbed any further
        start = b.start;
        end = b.end;
      }
    }

    result.add(new Interval(start, end));//This is for the last interval which has no more intervals to compare to. This can be a running/clubbed interval as well.


    //Convert result into [][]
    int[][] resultArray = new int[result.size()][];
    int i = 0;
    for(Interval it : result){
      int [] arr = {it.start, it.end};
      resultArray[i] = arr;
      i++;
    }

    return resultArray;

  }

  public static void main(String args[]){

  }
}
