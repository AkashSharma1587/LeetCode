/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
package java;

public class P746 {
  public int minCostClimbingStairs(int[] cost) {
    int dp[] = new int[cost.length+1];
    dp[0] = 0;
    dp[1] = Math.min(cost[0], 0);

    for(int i = 2; i <= cost.length; i++){
      dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
    }

    return dp[cost.length];


  }

}
