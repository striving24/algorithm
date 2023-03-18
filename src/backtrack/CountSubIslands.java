package backtrack;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-18 18:17
 * @Copyright © 2024未来可期
 * 1905. 统计子岛屿
 */
public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length,n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1){
                    //将不是的子岛的淹没
                    dfs(grid2,i,j);
                }
            }
        }
        int res = 0;
        //现在在grid2中遍历出来岛屿就是子岛
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1){
                    res++;
                    dfs(grid2,i,j);
                }
            }
        }
        return res;
    }

    //dfs框架：淹没岛屿
    void dfs(int[][] grid,int i,int j){
        int m = grid.length,n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n){
            return;
        }
        if (grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
