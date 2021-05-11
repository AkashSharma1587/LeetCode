//MEETING ROOMS : Minimum number of meeting rooms required to satisfy all intervals
package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P253 {
  class Interval{
    int start;
    int end;

    Interval(int start, int end){
      this.start = start;
      this.end = end;
    }
  }

  public int minMeetingRooms(int[][] intervals) {

    //Create Interval Objects
    List<Interval> intervalList = new ArrayList<>();
    for(int i = 0; i<intervals.length; i++){
      Interval interval = new Interval(intervals[i][0], intervals[i][1]);
      intervalList.add(interval);
    }

    if(intervalList.size()<2){
      return 1;
    }

    Collections.sort(intervalList, (a,b) -> Integer.compare(a.start, b.start));

    PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>          (intervalList.size(), (a,b)->Integer.compare(a.end, b.end));

    int minRooms = 0;
    for(Interval meeting: intervalList){
      while(!minHeap.isEmpty() && meeting.start >= minHeap.peek().end){
        minHeap.poll(); //Remove non-conflicting meetings
      }

      minHeap.offer(meeting);//Add current meeting
      minRooms = Math.max(minRooms, minHeap.size());
    }

    return minRooms;

  }

}
