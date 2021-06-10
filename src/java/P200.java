//Number of islands (connected components) - DFS
//Solution also possible through BFS and Union Find.
package java;

public class P200 {
  public int numIslands(char[][] grid) {
    if(grid == null || grid.length == 0)
      return 0;


    int nr = grid.length;
    int nc = grid[0].length;
    int islands = 0;
    for(int i = 0; i < nr; i++){
      for(int j = 0; j < nc; j++){
        if(grid[i][j] == '1')
        {
          islands++;
          dfs(grid, i, j);
        }
      }
    }

    return islands;

  }

  public void dfs(char[][] grid, int nr, int nc){
    int r = grid.length;
    int c = grid[0].length;

    if(nr < 0 || nc < 0 || nr > (r-1) || nc > (c-1) || grid[nr][nc] == '0'){
      return;
    }

    grid[nr][nc] = '0';

    dfs(grid, nr-1, nc);
    dfs(grid, nr+1, nc);
    dfs(grid, nr, nc+1);
    dfs(grid, nr, nc-1);
  }

}
