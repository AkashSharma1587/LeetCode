//K Closest points from origin

package java;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P973 {
  class Point{
    int x;
    int y;
    double dist;

    Point(int x, int y){
      this.x = x;
      this.y = y;
    }

    public void setDist(int xRef, int yRef){
      this.dist = Math.sqrt((x-xRef)*(x-xRef) + (y-yRef)*(y-yRef));
      System.out.println("Dist of "+x+" and "+y+" is "+this.dist);
    }

  }

  public int[][] kClosest(int[][] points, int k) {

    if(points.length < k)
      return points;


    PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, (a,b)->Double.compare(b.dist, a.dist));
    int count = k;
    List<Point> pointList = new ArrayList<>();
    for(int i = 0; i<points.length; i++){
      int[] point = points[i];
      Point p = new Point(point[0], point[1]);
      p.setDist(0,0);

      if(count > 0){
        maxHeap.offer(p);
        count--;
      }else{
        pointList.add(p);
      }
    }


    for(int j = 0; j<pointList.size(); j++){
      if( maxHeap.peek().dist > pointList.get(j).dist){
        maxHeap.poll();//Remove farther distance
        maxHeap.offer(pointList.get(j)); //Add nearer distance
      }
    }

    //Finally, maxHeap will contain k closest points.
    int result[][] = new int[maxHeap.size()][];
    int i = 0;
    while(!maxHeap.isEmpty()){
      Point p = maxHeap.poll();
      int ar[] = {p.x, p.y};
      result[i] = ar;
      i++;
    }

    return result;

  }
}
