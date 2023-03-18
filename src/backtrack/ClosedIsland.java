package backtrack;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-18 17:29
 * @Copyright © 2024未来可期
 * 1254、封闭的岛屿数量
 */
public class ClosedIsland {
    public int closedIsland(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        //提前将靠墙的陆地淹没
        for (int i = 0; i < m; i++) {
            //靠右边墙淹没
            dfs(grid,i,n-1);
            //靠左边墙淹没
            dfs(grid,i,0);
        }
        for (int i = 0; i < n; i++) {
            //靠上边墙淹没
            dfs(grid,0,i);
            //靠下边墙淹没
            dfs(grid,m-1,i);
        }
        //现在开始遍历grid，记录岛屿
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    //dfs框架:从（i,j）开始，将其相邻陆地变成海水（淹没岛屿）
    void dfs(int[][] grid,int i,int j){
        //base case 边界条件排除
        int m = grid.length,n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n){
            return;
        }
        if(grid[i][j] == 1){
            return;
        }
        //grid[i,j]变成海水
        grid[i][j] = 1;
        //递归（上下左右的都变成海水）
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
