// Free Employee time
package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class P759 {

  class Interval{
    int start;
    int end;

    Interval(int start, int end){
      this.start = start;
      this.end = end;
    }
  }
  class EmpInterval{
    Interval interval;
    int empIndex;//Index with schedule
    int intervalIndex; //Within each employee's list of intervals, the index

    public EmpInterval(Interval interval, int empIndex, int intervalIndex){
      this.interval = interval;
      this.empIndex = empIndex;
      this.intervalIndex = intervalIndex;
    }
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

    List<Interval> result = new ArrayList<>();

    List<List<Integer>> listOfList = new LinkedList<>();

    PriorityQueue<EmpInterval> minHeap = new PriorityQueue<>(schedule.size(), (a,b)->Integer.compare(a.interval.start, b.interval.start));

    //Add one interval of each employee to minHeap
    for(int i = 0; i < schedule.size(); i++){
      minHeap.offer(new EmpInterval(schedule.get(i).get(0), i, 0));
      //i is index of employee in schedule
      //0 is index of 0th schedule of a particular employee
    }




    Interval prevInterval = minHeap.peek().interval;
    while(!minHeap.isEmpty()){
      EmpInterval top = minHeap.poll();//remove top element
      if(prevInterval.end < top.interval.start){
        //No Overlap
        //Insert a free interval in result
        result.add(new Interval(prevInterval.end, top.interval.start ));//This won't be the case for first execution since top and prevInterval are same
        prevInterval = top.interval;
      } else{
        if(prevInterval.end < top.interval.end){
          prevInterval = top.interval;
        }
      }

      //Add other intervals from same employee
      List<Interval> empSchedule = schedule.get(top.empIndex);
      if(empSchedule.size() > top.intervalIndex + 1){
        minHeap.offer(new EmpInterval(empSchedule.get(top.intervalIndex + 1), top.empIndex, top.intervalIndex+1));
      }

    }//end of while loop

    return result;
  }

}

//There is a simpler solution but with more space complexity
// Put all the intervals (of all the employees) in the minHeap
// Track a running number of maxEnd (initialised with -1)
// If it is not the first heap element, and if you find gap between top.start and maxEnd, add that as a gap in the result
// This is similar to clubbing all intervals and merging them and finding gaps
