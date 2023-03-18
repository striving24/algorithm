package backtrack;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-18 17:59
 * @Copyright © 2024未来可期
 * 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        //记录岛屿的最大面积
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
        }
        return res;
    }
    //dfs框架，淹没岛屿,返回淹没岛屿的面积
    int dfs(int[][] grid,int i,int j){
        int m = grid.length,n = grid[0].length;
        //边界判断
        if (i < 0 || j < 0 || i >= m || j >= n){
            return 0;
        }
        if (grid[i][j] == 0){
            return 0;
        }
        return 1 + dfs(grid, i-1, j) +
         dfs(grid, i+1, j) +
         dfs(grid, i, j-1) +
         dfs(grid, i, j+1);
    }
}
