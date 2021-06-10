//Max Area of Island : DFS
package java;

public class P695 {

  static int maxArea = 0;
  public int maxAreaOfIsland(int[][] grid) {
    if(grid == null || grid.length == 0)
      return 0;

    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        if(grid[i][j] == 1){
          int maxCount = dfs(grid, i, j);
          maxArea = Math.max(maxArea, maxCount);
        }
      }
    }
    return maxArea;
  }

  public int dfs(int [][] grid, int m, int n){

    if(m >= grid.length || n >= grid[0].length || m < 0 || n < 0 || grid[m][n] == 0)         {
      return 0;
    }

    int ans = 0;
    if(grid[m][n] == 1){
      grid[m][n] = 0;
      ans = 1;
    }

    int left = dfs(grid, m-1,n);
    int right = dfs(grid, m+1, n);
    int bottom = dfs(grid, m, n-1);
    int top = dfs(grid, m, n+1);
    return ans+left+right+bottom+top;

  }

}
