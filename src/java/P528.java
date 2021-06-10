//Random Pick with weight
package java;

public class P528 {

  private int prefixSum[];
  private int total;
  public P528(int[] w) {
      prefixSum = new int[w.length];
      prefixSum[0] = w[0];
      total = w[0];
      for(int i = 1; i < w.length; i++){
        prefixSum[i] = prefixSum[i-1] + w[i];
        total += w[i];
      }
  }

  public int pickIndex() {
    double randTarget = Math.random() * total;
    int low = 0;
    int high = prefixSum.length-1;
    while (low <= high) {
      int mid = low + (high - low)/2;
      if(prefixSum[mid] == randTarget){
        return mid;
      }
      else if(randTarget > prefixSum[mid]){
        low = mid+1;
      }
      else{
        high = mid - 1;
      }


    }//end of while
    return low; //Exact match might not be possible because of double value compared with integer.

  }

}
