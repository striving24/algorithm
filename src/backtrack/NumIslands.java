package backtrack;

/**
 * @author 马祥
 * @Package backtrack
 * @date 2023-03-18 17:07
 * @Copyright © 2024未来可期
 * 200. 岛屿数量
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length,n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    //发现岛屿，结果加1
                    res++;
                    //将其变成岛屿
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    //DFS框架，从（i,j）开始，将与之相邻的陆地变成海水（淹没岛屿）
    void dfs(char[][] grid,int i,int j){
        //条件结束判断
        int m = grid.length,n = grid[0].length;
        if (i < 0 || j < 0 || i > m || j > n){
            //越界
            return;
        }
        if(grid[i][j] == '0'){
            //已经是海水了
            return;
        }
        //没有越界，则将该位置的陆地变成海水
        grid[i][j] = '0';
        //将左右上下的位置也变成海水
        //递归即可
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
