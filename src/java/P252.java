//MEETING ROOMS
package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P252 {

    class Interval{
      int start;
      int end;

      Interval(int start, int end){
        this.start = start;
        this.end = end;
      }
    }

    public boolean canAttendMeetings(int[][] intervals) {
      //Create Interval Objects
      List<Interval> intervalList = new ArrayList<>();
      for(int i = 0; i<intervals.length; i++){
        Interval interval = new Interval(intervals[i][0], intervals[i][1]);
        intervalList.add(interval);
      }

      if(intervalList.size()<2){
        return true;
      }

      Collections.sort(intervalList, (a,b) -> Integer.compare(a.start, b.start));

      for(int i=1;i<intervalList.size();i++){
        if(intervalList.get(i).start < intervalList.get(i-1).end)
          return false;

      }
      return true;

    }


}
