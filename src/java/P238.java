//Product of numbers of array except self
package java;

public class P238 {
  public int[] productExceptSelf(int[] nums) {

    int [] answer = new int[nums.length];

    answer[0] = 1;

    //answer has product of left subarray
    for(int i = 1; i < nums.length; i++){
      answer[i] = answer[i-1] * nums[i-1];
    }

    int R = 1;
    for(int j = nums.length -1; j>=0; j--){
      answer[j] = R * answer[j];
      R = R * nums[j];
    }

    return answer;

  }

}
