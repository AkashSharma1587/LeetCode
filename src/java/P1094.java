//Car Pooling
package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P1094 {
  class Interval{
    int start;
    int end;
    int count;

    Interval(int start, int end, int count){
      this.start = start;
      this.end = end;
      this.count = count;
    }
  }

  public boolean carPooling(int[][] trips, int capacity) {
    //Convert trips to Interval
    List<Interval> intervals = new ArrayList<>();

    for(int i = 0; i<trips.length; i++){
      int ar[] = trips[i];
      intervals.add(new Interval(ar[1], ar[2], ar[0]));
    }

    //Sort Intervals by start
    Collections.sort(intervals, (a,b)-> Integer.compare(a.start, b.start));

    //Use MinHeap of Interval (end time)
    //Check if total count is within capacity at all times
    //MinHeap to have only conflicting intervals
    PriorityQueue<Interval> minHeap = new PriorityQueue<>(intervals.size(),  (a,b)->Integer.compare(a.end, b.end));

    int presentCount = 0;

    for(Interval it : intervals){
      while(!minHeap.isEmpty() && it.start >= minHeap.peek().end){
        presentCount -= minHeap.peek().count;
        minHeap.poll();
      }

      minHeap.offer(it);
      presentCount += it.count;
      if(presentCount > capacity)
        return false;
    }//end of for-loop

    return true;

  }

}
