package prefix_and;

/**
 * @author 马祥
 * @Package prefix_and
 * @date 2023-02-10 23:01
 * @Copyright © 2024未来可期
 * 304、二维区域检索-矩阵不可变
 */
public class NumMatrix {
    //二维区域前缀和
    private int[][] preSum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        preSum = new int[m+1][n+1];
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    //计算子矩阵[x1,y1,x2,y2]的元素和
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row1][col2+1] - preSum[row2+1][col1] + preSum[row1][col1];
    }
}
